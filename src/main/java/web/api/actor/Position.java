package web.api.actor;

public class Position {
    private JobTitle jobTitle;
    private double standardPricePerHour;
    private double salaryCoefficient;

    public Position(JobTitle jobTitle, double standardPricePerHour, double coefficient) {
        this.jobTitle = jobTitle;
        this.standardPricePerHour = standardPricePerHour;
        this.salaryCoefficient = coefficient;
    }

    public enum JobTitle {MANAGER, SOFTWARE_ENGINEER, QUALITY_ENGINEER}

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
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
