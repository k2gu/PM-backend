package web.api.actor;

public class Position {
    private String jobTitle;
    private double standardPricePerHour;
    private double salaryCoefficient;

    public Position(String  jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Position(String jobTitle, double standardPricePerHour, double coefficient) {
        this.jobTitle = jobTitle;
        this.standardPricePerHour = standardPricePerHour;
        this.salaryCoefficient = coefficient;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getStandardPricePerHour() {
        return standardPricePerHour;
    }

    public void setStandardPricePerHour(double standardPricePerHour) {
        this.standardPricePerHour = standardPricePerHour;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }
}
