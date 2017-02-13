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

    public Job(final String jobId, final String name, final String customerId,
               final Calendar start, final Calendar end, final JobStatus status) {
        this.jobId = jobId;
        this.name = name;
        this.customerId = customerId;
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(final String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public Calendar getStart() {
        return start;
    }

    public void setStart(final Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(final Calendar end) {
        this.end = end;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(final JobStatus status) {
        this.status = status;
    }
}
