package web.db.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "in_position")
public class InPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "in_position_id")
    private int inPositionId;
    @Column(name = "position_id")
    private int positionId;
    @Column(name = "actor_id")
    private int actorId;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;

    public InPosition(int inPositionId, int positionId, int actorId, Date fromDate, Date toDate) {
        this.inPositionId = inPositionId;
        this.positionId = positionId;
        this.actorId = actorId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public InPosition() {
    }

    public int getInPositionId() {
        return inPositionId;
    }

    public void setInPositionId(int inPositionId) {
        this.inPositionId = inPositionId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
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
}
