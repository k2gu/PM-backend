package web.api.actor;

public class Client {
    private String name;

    public Client(String name, String businessNumber, double score) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
