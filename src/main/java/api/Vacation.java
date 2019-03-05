package api;

import java.util.ArrayList;
import java.util.List;

public class Vacation {

    private int id;
    private Employee reviewer;
    private Employee requester;
    private String type;
    private Boolean approved;
    private String fromDate;
    private String toDate;
    private String description;


    public Vacation(Boolean approved, Employee reviewer) {
        this.approved = approved;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getReviewer() {
        return reviewer;
    }

    public void setReviewer(Employee reviewer) {
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

    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }

    public static List<Vacation> getVacations() {
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 4; i > 0; i--) {
            vacations.add(new Vacation(true, new Employee()));
            vacations.add(new Vacation(false, new Employee()));
            vacations.add(new Vacation(null, null));
        }
        return vacations;
    }
}
