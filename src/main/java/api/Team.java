package api;

import java.util.List;

public class Team {
    private String name;
    private List<Employee> teamMembers;
    private Client client;

    public Team(String name, List<Employee> teamMembers, Client client) {
        this.name = name;
        this.teamMembers = teamMembers;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
