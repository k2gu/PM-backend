package web.db.datamodel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private int messageId;
    @Column(name = "from_actor")
    private int fromActorId;
    @Column(name = "to_actor")
    private int toActorId;
    private String message;
    @Column(name = "time_stamp")
    private Timestamp timestamp;

    public Message() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFromActorId() {
        return fromActorId;
    }

    public void setFromActorId(int fromActorId) {
        this.fromActorId = fromActorId;
    }

    public int getToActorId() {
        return toActorId;
    }

    public void setToActorId(int toActorId) {
        this.toActorId = toActorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimeStampString() {
        return timestamp.toString();
    }
}
