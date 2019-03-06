package web.db.datamodel;

import java.util.Date;

public class Vacation {
    private int vacationId;
    private int requestedByActor;
    private int reviewerId;
    private int vacationTypeId;
    private Boolean approved;
    private Date fromDate;
    private Date toDate;
    private String description;
}
