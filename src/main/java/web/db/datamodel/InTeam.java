package web.db.datamodel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "in_team")
public class InTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "in_team_id")
    private int inTeamId;
    @Column(name = "team_id")
    private int teamId;
    @Column(name = "actor_id")
    private int actorId;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;

    public InTeam() {
    }

    public int getInTeamId() {
        return inTeamId;
    }

    public void setInTeamId(int inTeamId) {
        this.inTeamId = inTeamId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
