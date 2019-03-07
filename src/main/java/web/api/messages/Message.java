package web.api.messages;

import web.api.actor.Client;
import web.api.actor.Employee;
import web.api.actor.Position;
import web.api.actor.Team;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private Employee to;
    private Employee from;

    private String timestamp;
    private String message;

    public Message(Employee employeeTo, Employee employeeFrom, String timeStamp, String message) {
        this.to = employeeTo;
        this.from = employeeFrom;
        this.timestamp = timeStamp;
        this.message = message;
    }

    public Employee getEmployeeTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public static List<Message> getMockedMessagesList() {
        Position myPosition = new Position("SOFTWARE_ENGINEER", 100.0, 0.1);
        Position messagerPosition = new Position("MANAGER", 200.0, 0.2);
        Client client = new Client(123,"I am a Client", "businessNumber", 99.8);
        Team team = new Team("Team name", client);
        List<Team> teams = new ArrayList<>();
        teams.add(team);
        Employee me = new Employee(1, "Employee Name Me", myPosition, teams,
                65.9, "SSN58390384082", "IBAN4890859084504938054");
        Employee messager = new Employee(2, "Employee Name Messager", messagerPosition, teams,
                70.8, "SSN94085904", "IBANk484853905854389053");
        Message message = new Message(me, messager, "03.03.2019",
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
