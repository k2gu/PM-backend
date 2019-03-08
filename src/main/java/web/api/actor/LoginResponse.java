package web.api.actor;

public class LoginResponse {
    private int responseCode;
    private String message;
    private String sessionId;
    private int employeeId;
    private boolean isManager;
    private String name;

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isManager() {
        return isManager;
    }

    public String getName() {
        return name;
    }
}
