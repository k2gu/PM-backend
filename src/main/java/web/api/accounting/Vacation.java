package web.api.accounting;

public class Vacation {

    private int id;
    private Integer reviewer;
    private int requester;
    private String type;
    private Boolean approved;
    private String fromDate;
    private String toDate;
    private String description;

    public Vacation(int id, int reviewer, int requester, String type, Boolean approved, String fromDate, String toDate, String description) {
        this.id = id;
        this.reviewer = reviewer;
        this.requester = requester;
        this.type = type;
        this.approved = approved;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
    }
    public Vacation(int id, int requester, String type, String fromDate, String toDate, String description) {
        this.id = id;
        this.requester = requester;
        this.type = type;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequester() {
        return requester;
    }

    public void setRequester(int requester) {
        this.requester = requester;
    }
}
