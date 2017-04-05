package edu.nyu.cs9053.homework8;

import edu.nyu.cs9053.homework8.Job;
import edu.nyu.cs9053.homework8.JobSubset;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: rv913
 * Date: 04/03/17
 * Time: 1:20 PM
 */

public class LambdaWeightedScheduler{
	
    /**
    * Returns the optimal set of jobs with maximum cost. (time frame considered as maximum finish time)
    * @param jobs list of jobs
    * returns a JobSubset class object having optimal list of jobs with maximum total cost
    */
    public JobSubset weightedJobScheduler(List<Job> jobs)
    {
        if(jobs==null){
            return null;
        }
        int numberOfJobs = jobs.size();
        // Sort the jobs with respect to their finish time
        Collections.sort(jobs);
        // Array to store total cost and its subset of jobs
        List<JobSubset> jobSubset = new ArrayList<JobSubset>(numberOfJobs);

        List<Job> jobList = new ArrayList<Job>(numberOfJobs);
        jobList.add(jobs.get(0));
        jobSubset.add(new JobSubset(jobList, jobs.get(0).getCost()));
        
        for(int index=1; index < numberOfJobs; index++){
            addOptimalCurrentJob(jobSubset, jobs, index);
        }
        return jobSubset.get(numberOfJobs-1);
    }

    /**
    * Adds the job to subset list if it is an optimal job
    * @param jobSubset list of job subset objects
    * @param jobs list of jobs
    * @param index index of current job
    */
    private void addOptimalCurrentJob(List<JobSubset> jobSubset, List<Job> jobs, int index){
        
        double currentJobCost = jobs.get(index).getCost();
        int nonConflictIndex = getNonConflictJobIndex(jobs, index);
        if (nonConflictIndex != - 1)
            currentJobCost += jobSubset.get(nonConflictIndex).getTotalCost();
        // If including current job cost is greater than previous jobs total cost, add current job to list
        if (currentJobCost > jobSubset.get(index-1).getTotalCost())
        {   
            if(jobSubset.get(nonConflictIndex).getJobs() != null){
                List<Job> jobSubList = new ArrayList<>(jobSubset.get(nonConflictIndex).getJobs());
                jobSubList.add(jobs.get(index));
                jobSubset.add(new JobSubset(jobSubList, currentJobCost));
            }
        }
        else{
            jobSubset.set(index, jobSubset.get(index-1));
        }
    }

    /**
    * Binary Search to get the job index that doesn't conflict with current job.
    * @param jobs list of jobs
    * @param index index of current job
    * return index of non-conflict job
    */
    private int getNonConflictJobIndex(List<Job> jobs, int index)
    {
        int low = 0, high = index - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            // Check for conflict
            if (jobs.get(mid).getFinishTime() <= jobs.get(index).getStartTime())
            {
                if (jobs.get(mid+1).getFinishTime() <= jobs.get(index).getStartTime())
                    low = mid + 1;
                else
                    return mid;
            }
            else
                high = mid - 1;
        }
        return -1;
    }
}


    








