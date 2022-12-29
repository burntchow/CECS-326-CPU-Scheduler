/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

public class RR implements Algorithm{

    /* Variables */
    List<Task> queue = new ArrayList<Task>();
    ListIterator<Task> iter;   

    /* RR Constructor */
    public RR(List<Task> q){
        this.queue = q;
        this.iter = queue.listIterator();
    }

    /**
     * Invokes the scheduler
     */
    public void schedule(){
        //NOTE TO SELF: Time quantum is 10 ms
        System.out.println("Round Robin Scheduling\n");
        Task temp; 
    
        while(queue.isEmpty() == false){ 
        
            temp = this.pickNextTask(); 
            int time;
            
            if(temp.getBurst() > 10){ // Comparing burst to time quantum
                // If greater than 10, time subtracted will be time quantum
                time = 10;
            } else{
                // Else the time substracted from burst is itself
                time = temp.getBurst();
            }
                
            CPU.run(temp, time); 
            temp.setBurst(temp.getBurst()-time); // Calculate remaining burst
        
            if(temp.getBurst() <= 0){ // If no more burst, Task/Process over and can remove from queue
                iter.remove();
                System.out.println("Task " + temp.getName() + " finished.");
            }
            
        }
    }

    /**
     * Selects the next task using the appropriate scheduling algorithm
     */
    public Task pickNextTask(){
        /**
        Goes thru each process one by one
        if it still hasnt fully executed, keep in queue
        if not, delete
        **/     
        
        if(iter.hasNext()){ // Must check if there is still a task next
            return iter.next(); 
        
        }else{ // If no task ahead, need to reset iterator to beginning
            // System.out.println("HI IVE RESET :)");
            iter = queue.listIterator();
            iter.next();
        } 
        return queue.get(0);
    }
}