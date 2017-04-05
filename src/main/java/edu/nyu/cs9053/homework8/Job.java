package edu.nyu.cs9053.homework8;

/**
 * User: rv913
 * Date: 04/02/17
 * Time: 1:40 PM
 */

// Job with fields start time, finish time and cost
public class Job implements Comparable<Job>{
	
	private final long startTime;
	private final long finishTime;
	private final double cost;

	Job(long startTime, long finishTime, double cost){
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.cost = cost;
	}

	public long getStartTime(){
		return this.startTime;
	}

	public long getFinishTime(){
		return this.finishTime;
	}

	public double getCost(){
		return this.cost;
	}

	@Override
	public int compareTo(Job job){
		if(this.getFinishTime() < job.getFinishTime()){
			return -1;
		}
		if(this.getFinishTime() > job.getFinishTime()){
			return 1;
		}
		return 0;
	}
}