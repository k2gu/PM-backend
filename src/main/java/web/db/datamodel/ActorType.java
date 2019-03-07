package web.db.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "actor_type")
public class ActorType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_type_id")
    private int actorTypeID;
    @Column(name = "Type")
    private String type;

    public ActorType() {
    }

    public ActorType(int actorTypeID, String type) {
        this.actorTypeID = actorTypeID;
        this.type = type;
    }

    public int getActorTypeID() {
        return actorTypeID;
    }

    public void setActorTypeID(int actorTypeID) {
        this.actorTypeID = actorTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
