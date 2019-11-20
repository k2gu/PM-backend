package web.api.actor;

public class LoginResponse {
    private String sessionId;
    private int employeeId;
    private boolean isManager;
    private String name;

    void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
