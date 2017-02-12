package cai.peter.interview.q4;

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
    public static JobStatus calculateJobStatus(final Job jbo, final Set<Allocation> allocations) {
        //TODO to implement
        return JobStatus.FINISHED;
    }
}
