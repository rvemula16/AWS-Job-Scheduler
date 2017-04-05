package edu.nyu.cs9053.homework8;

import edu.nyu.cs9053.homework8.Job;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

/**
 * User: rv913
 * Date: 04/03/17
 * Time: 11:40 PM
 */

public class LambdaScheduler{
	
	/**
	* Return the optimal list of jobs that can be performed in a given time frame
	* @param jobPriorityQueue priority queue of jobs ordered by their finish time
	* @param timeFrame length of the time frame
	* returns the maximum subset of jobs that can be performed
	*/
	public List<Job> jobScheduler(Queue<Job> jobPriorityQueue, long timeFrame){

    	if(jobPriorityQueue==null){
    		return null;
    	}

    	List<Job> compatibleJobs = new ArrayList<Job>(jobPriorityQueue.size());
    	while(jobPriorityQueue.size()!=0){
    		Job job = jobPriorityQueue.peek();
            long jobDuration = job.getFinishTime() - job.getStartTime();
    		if(checkForCompatibility(compatibleJobs, job) && jobDuration <= timeFrame){
                compatibleJobs.add(job);
                timeFrame -= jobDuration;
            }
    		jobPriorityQueue.remove();
    		if(timeFrame == 0)
    			break;
    	}
    	return compatibleJobs;
	}

    /**
    * Checks if current job is compatible
    * @param compatibleJobs list of jobs
    * @param job current job
    * returns true if job is compatible, else false
    */
    private boolean checkForCompatibility(List<Job> compatibleJobs, Job job){
        if(compatibleJobs==null || job==null){
            return false;
        }
        if(compatibleJobs.size() == 0){
            return true;
        }
        else{
            Job previousjob = compatibleJobs.get(compatibleJobs.size()-1);
            if(previousjob.getFinishTime() <= job.getStartTime()){
               return true;
            }
        }
        return false;
    }
}











