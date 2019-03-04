package api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Work {

    private Date date;
    private double hoursSpent;
    private Team team;
    private Category category;
    private String taskID;
    private String description;

    Work(Date workDone, int hoursSpent, Team team, Category category, String taskID, String description) {
        this.date = workDone;
        this.hoursSpent = hoursSpent;
        this.team = team;
        this.category = category;
        this.taskID = taskID;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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


    public static List<Work> getWorkHours() {
        List<Work> previouslyDoneWork = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            previouslyDoneWork.add(new Work(null, 10+i, new Team("Team name",
                    null, null), Category.DEVELOPMENT, "120429023", "description"));
        }
        return previouslyDoneWork;
    }

    private enum Category {MEETINGS, TESTING, DEVELOPMENT, ANALYSIS, OTHER_WORK}
}
