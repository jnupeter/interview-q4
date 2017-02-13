package cai.peter.interview.q4.model;

/**
 * Created by peter on 12/02/17.
 */
public class Allocation {
    private String allocId;
    private String employeeId;
    private String jobId;
    private AllocStatus status;

    public Allocation(final String allocId, final String employeeID, final String jobId, final AllocStatus status) {
        this.allocId = allocId;
        this.employeeId = employeeID;
        this.jobId = jobId;
        this.status = status;
    }

    public String getAllocId() {
        return allocId;
    }

    public void setAllocId(final String allocId) {
        this.allocId = allocId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(final String jobId) {
        this.jobId = jobId;
    }

    public AllocStatus getStatus() {
        return status;
    }

    public void setStatus(final AllocStatus status) {
        this.status = status;
    }
}
