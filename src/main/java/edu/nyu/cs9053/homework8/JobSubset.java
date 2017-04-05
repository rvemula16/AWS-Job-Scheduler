package edu.nyu.cs9053.homework8;

import edu.nyu.cs9053.homework8.Job;
import java.util.List;
import java.util.ArrayList;

/**
 * User: rv913
 * Date: 04/03/17
 * Time: 12:20 PM
 */

// Subset of jobs with their total cost
public class JobSubset{

    private final List<Job> jobs;
    private final double totalCost;
    
    JobSubset(List<Job> jobs, double totalCost){
        this.jobs = new ArrayList<Job>(jobs);
        this.totalCost = totalCost;
    }

    public double getTotalCost(){
        return this.totalCost;
    }

    public List<Job> getJobs(){
        return this.jobs;
    }
}