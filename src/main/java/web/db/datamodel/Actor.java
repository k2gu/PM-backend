package web.db.datamodel;

import javax.persistence.*;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int actorId;
    @Column(name = "actor_type_id")
    private int actorTypeId;
    @Column(name = "reports_to_actor_id")
    private Integer reportsToActorId;
    @Column(name = "actor_name")
    private String name;
    private String identificator;
    @Column(name = "avatar_uri")
    private String avatarUri;
    private double score;
    private String iban;

    public Actor() {

    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getActorTypeId() {
        return actorTypeId;
    }

    public void setActorTypeId(int actorTypeId) {
        this.actorTypeId = actorTypeId;
    }

    public Integer getReportsToActorId() {
        return reportsToActorId;
    }

    public void setReportsToActorId(Integer reportsToActorId) {
        this.reportsToActorId = reportsToActorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
