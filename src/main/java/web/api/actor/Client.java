package web.api.actor;

public class Client {
    private String name;
    private int id;

    public Client(int id, String name, String businessNumber, double score) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
