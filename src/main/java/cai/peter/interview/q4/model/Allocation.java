package cai.peter.interview.q4.model;

/**
 * Created by peter on 12/02/17.
 */
public class Allocation {
    private String allocId;
    private String employeeId;
    private String jobId;
    private AllocStatus status;

    public Allocation(String allocId, String employeeID, String jobId, AllocStatus status) {
        this.allocId = allocId;
        this.employeeId = employeeID;
        this.jobId = jobId;
        this.status = status;
    }
}
