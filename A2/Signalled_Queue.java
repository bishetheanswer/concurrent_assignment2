package concurrent_assignment2.A2;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use the synchronized keyword and signals so that
 * you do not need to busy wait.
 * But of course you still need your variable to know
 * whose's turn it is.
 *
 */
 
class Signalled_Queue implements Queue{
	
    volatile int n = 0;
    volatile boolean cond=false;

    @Override
    synchronized public void read() {
        if(!cond){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(n);
        cond=false;
        notify();
    }

    @Override
    synchronized public void write(int x) {
            // TODO Auto-generated method stub
            if(cond){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            n++;
            System.out.println(n);
            cond=true;
            notify();
            
    }

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
}


