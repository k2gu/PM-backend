package web.api.accounting;

import web.api.actor.Employee;
import web.api.actor.Team;

public class Work {

    private Integer id;
    private String date;
    private double hoursSpent;
    private Team team;
    private String category;
    private String taskID;
    private String description;
    private Employee employee;

    Work(Integer id, Employee employee , double hoursSpent, Team team, String category, String taskID, String description) {
        this.id = id;
        this.employee = employee;
        this.hoursSpent = hoursSpent;
        this.team = team;
        this.category = category;
        this.taskID = taskID;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHoursSpent() {
        return hoursSpent;
    }

    public void setHoursSpent(double hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getWorker() {
        return employee;
    }

    public void setWorker(Employee worker) {
        this.employee = worker;
    }
}
