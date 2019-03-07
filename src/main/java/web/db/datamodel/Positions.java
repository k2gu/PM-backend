package web.db.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Positions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private int positionId;
    @Column(name = "position_title")
    private String title;
    @Column(name = "price_per_hour")
    private double pricePerHour;
    @Column(name = "salary_coef")
    private double salaryCoef;

    public Positions(int positionId, String title, double pricePerHour, double salaryCoef) {
        this.positionId = positionId;
        this.title = title;
        this.pricePerHour = pricePerHour;
        this.salaryCoef = salaryCoef;
    }

    public Positions() {
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getSalaryCoef() {
        return salaryCoef;
    }

    public void setSalaryCoef(double salaryCoef) {
        this.salaryCoef = salaryCoef;
    }
}
