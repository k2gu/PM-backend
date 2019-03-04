package api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Message {
    private Employee to;
    private Employee from;
    private Date timestamp;
    private String message;

    public Message(Employee employeeTo, Employee employeeFrom, Date timeStamp, String message) {
        this.to = employeeTo;
        this.from = employeeFrom;
        this.timestamp = timeStamp;
        this.message = message;
    }

    public Employee getEmployeeTo() {
        return to;
    }

    public String getEmployeeFromName() {
        return from.getName();
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public static List<Message> getMockedMessagesList() {
        Position myPosition = new Position(Position.JobTitle.SOFTWARE_ENGINEER, 100.0, 0.1);
        Position messagerPosition = new Position(Position.JobTitle.MANAGER, 200.0, 0.2);
        Client client = new Client("I am a Client", "businessNumber", 99.8);
        Team team = new Team("Team name", null, client);
        Employee me = new Employee(1, "Employee Name Me", myPosition, team,
                65.9, "SSN58390384082", "IBAN4890859084504938054");
        Employee messager = new Employee(2, "Employee Name Messager", messagerPosition, team,
                70.8, "SSN94085904", "IBANk484853905854389053");
        Message message = new Message(me, messager, Calendar.getInstance().getTime(),
                "Urgent message here!");
        ArrayList<Message> messageList = new ArrayList();
        for (int i = 10; i >= 0; i--)
            messageList.add(message);
        return messageList;
    }
    public Employee getTo() {
        return to;
    }

    public void setTo(Employee to) {
        this.to = to;
    }

    public Employee getFrom() {
        return from;
    }

    public void setFrom(Employee from) {
        this.from = from;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
