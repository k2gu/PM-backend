package web.db.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacation_id")
    private int vacationId;
    @Column(name = "requested_by_actor_id")
    private int requestedByActor;
    @Column(name = "reviewer_actor_id")
    private Integer reviewerId;
    @Column(name = "vacation_type_id")
    private int vacationTypeId;
    private Boolean approved;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;
    private String description;

    public Vacation() {
    }

    public int getVacationId() {
        return vacationId;
    }

    public void setVacationId(int vacationId) {
        this.vacationId = vacationId;
    }

    public int getRequestedByActor() {
        return requestedByActor;
    }

    public void setRequestedByActor(int requestedByActor) {
        this.requestedByActor = requestedByActor;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public int getVacationTypeId() {
        return vacationTypeId;
    }

    public void setVacationTypeId(int vacationTypeId) {
        this.vacationTypeId = vacationTypeId;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
