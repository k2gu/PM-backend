package web.api.actor;

public class Team {
    private String name;
    private Client client;

    public Team(String name, Client client) {
        this.name = name;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
