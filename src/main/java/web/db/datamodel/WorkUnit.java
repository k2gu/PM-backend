package web.db.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_unit")
public class WorkUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_id")
    private int workUnitId;
    @Column(name = "work_type_id")
    private int workTypeId;
    @Column(name = "in_position_id")
    private int inPositionId;
    @Column(name = "in_team_id")
    private int inTeamId;
    @Column(name = "done_date")
    private Date dateDone;
    @Column(name = "time_spent")
    private  double timeSpent;
    @Column(name = "task_number")
    private String tasknumber;
    private  String description;
    private Boolean approver;
    @Column(name = "reviewer_actor_id")
    private Integer reviewerId;

    public WorkUnit() {
    }

    public int getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(int workUnitId) {
        this.workUnitId = workUnitId;
    }

    public int getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(int workTypeId) {
        this.workTypeId = workTypeId;
    }

    public int getInPositionId() {
        return inPositionId;
    }

    public void setInPositionId(int inPositionId) {
        this.inPositionId = inPositionId;
    }

    public int getInTeamId() {
        return inTeamId;
    }

    public void setInTeamId(int inTeamId) {
        this.inTeamId = inTeamId;
    }

    public Date getDateDone() {
        return dateDone;
    }

    public void setDateDone(Date dateDone) {
        this.dateDone = dateDone;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getTasknumber() {
        return tasknumber;
    }

    public void setTasknumber(String tasknumber) {
        this.tasknumber = tasknumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
