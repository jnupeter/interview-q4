package cai.peter.interview.q4.model;

import java.util.Calendar;

/**
 * Created by peter on 12/02/17.
 */
public class Job {
    private String jobId;
    private String name;
    private String customerId;
    private Calendar start;
    private Calendar end;
    private JobStatus status;

    public Job(String jobId, String name, String customerId, Calendar start, Calendar end, JobStatus status) {
        this.jobId = jobId;
        this.name = name;
        this.customerId = customerId;
        this.start = start;
        this.end = end;
        this.status = status;
    }

}
