package api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vacation {
    private Date to;
    private Date from;
    private Type type;
    private String comment;

    public enum Type {STUDY, REGULAR, MATERNITY}

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static List<Vacation> getVacations() {
        List<Vacation> vacations = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            vacations.add(new Vacation());
        }
        return vacations;
    }
}
