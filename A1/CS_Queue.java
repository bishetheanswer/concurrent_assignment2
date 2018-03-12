package concurrent_assignment2.A1;

import concurrent_assignment2.A_intro.Queue;

/**Use condition synchronization by means of busy wait.
 * 
 * What kind of variable do you need to implement busy
 * wait synchronization?
 * 
 * Set a meaningful name for such variable.
 * */
 
class CS_Queue implements Queue{
	volatile int n=0;
	volatile boolean cond=false;
	@Override
	public void read() {
            while(!cond){};
            System.out.println(n);
            cond = false;
            
		
	}

	@Override
	public void write(int x) {
            while(cond){};
            n++;
            System.out.println(n);
            cond = true;
            }

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
	
	
}


