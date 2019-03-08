package web.api.actor;

public class Client {
    private String name;
    private String businessNumber;
    private double score;
    private int id;

    public Client() {
    }

    public Client(int id, String name, String businessNumber, double score) {
        this.name = name;
        this.businessNumber = businessNumber;
        this.score = score;
        this.id = id;
    }

    public Client(int actorId, String name) {
        this.id = actorId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
