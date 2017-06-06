# AWS JOB SCHEDULER

To optimize the cluster of EC2 machines which are running the Lambda jobs in containers.
For context, each Lambda job consists of the following: a starting time _s_ until a final time _t_.  Assume the job can be run by at most one container at a time.  
The goal is to select a compatible subset of jobs of maximum possible size.
More formally, there will be n jobs labeled 1...n with each job, j, specifying a start time Sj and a finish time Tj.  Naturally we have Sj < Tj for all j.  Two jobs j and j1 are compatible if the requested intervals do not overlap; that is, either job j is for an earlier time interval than job j1 (Tj <= Sj1), or job j is for a later time than job j1 (Tj1 <= Sj).  More generally, that a subset A of jobs is compatible if all pairs of jobs j,j1 within A, j!= j1 are compatible.

# Lambda Scheduler:
Scheduler to maximize the number of jobs a single container can accept.  

# Lambda Weighted Scheduler:
In this case someone would pay more money to have their job run first. Jobs are prioritized.
Instead of optimizing for the number of jobs, we now maximize for the total value (i.e. each job now as an associated cost or weight and we are optimizing for the largest cost).
