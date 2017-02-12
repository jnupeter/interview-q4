package cai.peter.interview.q4;

import cai.peter.interview.q4.model.AllocStatus;
import cai.peter.interview.q4.model.Allocation;
import cai.peter.interview.q4.model.Job;
import cai.peter.interview.q4.model.JobStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by peter on 12/02/17.
 */
public class JobStatusCalculatorTest {

    @Test
    public void if_the_job_doesnot_have_a_time_yet_it_should_be_marked_as_queued() {
        Job job = new Job(null, null, null, null, null, null);
        Set<Allocation> allocations = Collections.emptySet();

        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("if the job doesn't have a time yet, it should be marked as Queued", JobStatus.QUEUED, result);
    }

    @Test
    public void if_the_job_has_a_time_but_no_allocated_employees_mark_as_pending_allocation() {
        Job job = new Job(null, null, null, Calendar.getInstance(), null, null);
        Set<Allocation> allocations = Collections.emptySet();

        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("if the job has a time but has no allocated employees, mark as 'Pending Allocation'", JobStatus.PENDING_ALLOCATION, result);
    }

    @Test
    public void if_the_job_has_one_or_more_employees_but_hasnot_been_started_mark_as_ready() {
        Job job = new Job(null, null, null, Calendar.getInstance(), null, null);
        Set<Allocation> allocations = new HashSet<>();

        //hasn't been started means in AllocStatus.ALLOCATED
        allocations.add(new Allocation(null, null, null, AllocStatus.ALLOCATED));
        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("if the job has one or more employees but hasn't been started, mark as 'Ready'", JobStatus.READY, result);
    }

    @Test
    public void if_any_of_the_employees_have_started_the_job_is_in_progress() {
        Job job = new Job(null, null, null, Calendar.getInstance(), null, null);
        Set<Allocation> allocations = new HashSet<>();

        allocations.add(new Allocation(null, null, null, AllocStatus.ALLOCATED));
        allocations.add(new Allocation(null, null, null, AllocStatus.IN_PROGRESS));
        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("if any of the employees have started, the job is 'In progress'", JobStatus.IN_PROGRESS, result);
    }

    @Test
    public void if_all_of_the_employees_have_finished_the_job_is_finished() {
        Job job = new Job(null, null, null, Calendar.getInstance(), null, null);
        Set<Allocation> allocations = new HashSet<>();

        allocations.add(new Allocation("1", null, null, AllocStatus.FINISHED));
        allocations.add(new Allocation("2", null, null, AllocStatus.FINISHED));
        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("if all of the employees have finished, the job is 'Finished'", JobStatus.FINISHED, result);

        allocations.add(new Allocation("2", null, null, AllocStatus.IN_PROGRESS));
        result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertNotEquals("if all of the employees have finished, the job is 'Finished'", JobStatus.FINISHED, result);
    }

    @Test
    public void the_job_with_previous_completed_it_always_stays_completed(){
        Job job = new Job(null, null, null, Calendar.getInstance(), null, JobStatus.FINISHED);
        Set<Allocation> allocations = Collections.EMPTY_SET;

        JobStatus result = JobStatusCalculator.calculateJobStatus(job, allocations);
        Assert.assertEquals("completed job should remain completed no matter what", JobStatus.FINISHED, result);
    }
}
