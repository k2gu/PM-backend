package web.api.messages;

import web.api.actor.Employee;

public class Message {
    private Integer messageId;
    private int to;
    private Employee from;
    private String timestamp;
    private String message;

    public Message(Integer messageId, int employeeTo, Employee employeeFrom, String timeStamp, String message) {
        this.to = employeeTo;
        this.messageId = messageId;
        this.from = employeeFrom;
        this.timestamp = timeStamp;
        this.message = message;
    }

    public int getEmployeeTo() {
        return to;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
