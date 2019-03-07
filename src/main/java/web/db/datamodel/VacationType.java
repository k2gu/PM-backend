package web.db.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "vacation_type")
public class VacationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacation_type_id")
    private int vacationTypeID;
    private String type;
}
