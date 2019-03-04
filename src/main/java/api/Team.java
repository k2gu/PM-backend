package api;

import java.util.List;

public class Team {
    private String teamName;
    private List<Employee> teamMembers;
    private Client client;

    public Team(String name, List<Employee> teamMembers, Client client) {
        this.teamName = name;
        this.teamMembers = teamMembers;
        this.client = client;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
