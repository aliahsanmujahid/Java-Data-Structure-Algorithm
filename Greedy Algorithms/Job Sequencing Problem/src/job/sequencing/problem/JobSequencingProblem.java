
package job.sequencing.problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Job
{
    private char taskID;int deadline, profit;
 
    public Job(char taskID, int deadline, int profit) {
        this.taskID = taskID;
        this.deadline = deadline;
        this.profit = profit;
    }
 
    public int getDeadline() {
        return deadline;
    }
 
    public int getProfit() {
        return profit;
    }
 
    public char getTaskID() {
        return taskID;
    }

};
public class JobSequencingProblem {
     public static int scheduleJobs(List<Job> jobs, int T)
    {
        // stores maximum profit that can be earned by scheduling jobs
        int profit = 0;
 
        // array to store used and unused slots info
        int[] slot = new int[T];
        Arrays.fill(slot, -1);
 
        // consider each job in decreasing order of their profits
        for (Job job: jobs)
        {
            // search for next free slot and map the task to that slot
            for (int j = job.getDeadline() - 1; j >= 0; j--)
            {
                if (j < T && slot[j] == -1)
                {
                    slot[j] = job.getTaskID();
                    profit += job.getProfit();
                    break;
                }
            }
        }
 
        // print the scheduled jobs
        System.out.println("The Scheduled jobs are - ");
        for (int i=0; i<T; i++) {
             if (slot[i]!=-1) 
                System.out.print(jobs.get(i).getTaskID()+" ");
                 
        }
      
 
        // return total profit that can be earned
        return profit;
    }
public static void main(String[] args)
    {
        // List of given jobs. Each job has an identifier, a deadline and
        // profit associated with it
        List<Job> jobs = Arrays.asList(
                new Job('a', 2, 100), new Job('b', 1, 19),
                new Job('c', 2, 27), new Job('d', 1, 25),
                new Job('e', 3, 15)
        );
 
        // stores maximum deadline that can be associated with a job
        final int T = 15;
 
        // arrange the jobs in decreasing order of their profits
        Collections.sort(jobs, (a, b) -> b.getProfit() - a.getProfit());
 
        // schedule jobs and calculate maximum profit
        System.out.println("\nTotal Profit is: " + scheduleJobs(jobs, T));
    }
}
