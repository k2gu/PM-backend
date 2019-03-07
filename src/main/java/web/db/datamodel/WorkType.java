package web.db.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "work_type")
public class WorkType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_type_id")
    private int workTypeId;
    @Column(name = "Type")
    private String type;

    public WorkType() {
    }

    public int getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(int workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
