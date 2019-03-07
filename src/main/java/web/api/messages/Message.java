package web.api.messages;

public class Message {
    private Integer messageId;
    private int to;
    private int from;
    private String timestamp;
    private String message;

    public Message(Integer messageId, int employeeTo, int employeeFrom, String timeStamp, String message) {
        this.to = employeeTo;
        this.messageId = messageId;
        this.from = employeeFrom;
        this.timestamp = timeStamp;
        this.message = message;
    }

    public int getEmployeeTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
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
