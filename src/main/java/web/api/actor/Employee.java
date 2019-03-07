package web.api.actor;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private Position position;
    private List<Team> teams;
    //private BitMap image;
    private double score;
    private String ssn;
    private String iban;

    public Employee() {
    }

    public Employee(int id, String name, Position position, List<Team> teams, double score, String ssn, String iban) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.teams = teams;
        // this.image = image;
        this.score = score;
        this.ssn = ssn;
        this.iban = iban;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeam(List<Team> teams) {
        this.teams = teams;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
