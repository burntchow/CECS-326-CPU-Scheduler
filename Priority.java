/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority implements Algorithm{
    /* Variable */
    List<Task> queue;

    /**
     * Priority Constructor 
     * Uses the Collections.sort() function - compare is Overridden in Task
     * to sort Tasks by priority
     * Calls the schedule() function 
     * IN: List<Task> from the Driver class
     */
    public Priority(List<Task> q){
        this.queue = q; 
        Collections.sort(this.queue);
    }
    
    /**
     * Invokes the scheduler
     */
    public void schedule(){
        System.out.println("Priority Scheduling\n");

        // Want an integer to store the original queue size because it will change in pickNextTask()
        int queueLen = queue.size(); 

        // Temporary Task object for the current task
        Task temp;
      
        // for loop used to schedule all tasks in queue
        for(int i = 0; i < queueLen; i++){
            temp = this.pickNextTask(); 
            // Statically call run in CPU class - will print to terminal the Task and its information
            CPU.run(temp, temp.getBurst());
            System.out.println("Task " + temp.getName() + " finished.\n");
        }
    }

    /**
     * Selects the next task using the appropriate scheduling algorithm
     */
    public Task pickNextTask(){
        // remove(index) will remove the Task element at that index
        // and return that value, prevents scheduling duplicates 
        return queue.remove(0); 
    }
}
