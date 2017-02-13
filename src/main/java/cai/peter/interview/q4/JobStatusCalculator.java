package cai.peter.interview.q4;

import cai.peter.interview.q4.model.AllocStatus;
import cai.peter.interview.q4.model.Allocation;
import cai.peter.interview.q4.model.Job;
import cai.peter.interview.q4.model.JobStatus;

import java.util.Set;

/**
 * Created by peter on 12/02/17.
 */
public final class JobStatusCalculator {

    private JobStatusCalculator() {
        // private constructor to prevent being instanciated
    }

    // the implementation
    public static JobStatus calculateJobStatus(final Job job, final Set<Allocation> allocations) {
        final JobStatus status = job.getStatus();
        if (status != null && status.equals(JobStatus.FINISHED)) {
            return JobStatus.FINISHED;
        } else if (job.getStart() == null){
            return JobStatus.QUEUED;
        } else if (allocations.size() == 0) { //has time but no employee
            return JobStatus.PENDING_ALLOCATION;
        } else { // at least one employee is allocated
            if (allocations.stream().map(a -> a.getStatus()).anyMatch(s -> s == AllocStatus.IN_PROGRESS)) {
                return JobStatus.IN_PROGRESS;
            } else if (allocations.stream().map(a -> a.getStatus()).allMatch(s -> s == AllocStatus.FINISHED)) {
                return JobStatus.FINISHED;
            } else {
                return JobStatus.READY;
            }
        }

    }
}
