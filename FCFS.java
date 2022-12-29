/**
 * FCFS scheduling algorithm.
 * Schedules tasks in the order in which they request the CPU
 */
 
import java.util.*;

public class FCFS implements Algorithm{
    /* Variable */
    List<Task> queue;

    /**
     * FCFS Constructor 
     * Calls the schedule() function 
     * IN: List<Task> from the Driver class
     */
    public FCFS(List<Task> q){
        this.queue = q; 
    }

    /**
     * Invokes the scheduler
     */
    public void schedule(){
        System.out.println("First-Come-First-Served FCFS Scheduling\n");

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