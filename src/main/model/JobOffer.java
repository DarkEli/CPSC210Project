package model;

public class JobOffer {

    private String companyName;
    private String jobPosition;
    private String jobLocation;
    private double annualSalary;
    private double signingBonus;
    private int stockAmount;
    private double stockPriceCurrent;

    public JobOffer(String companyName, String jobPosition, String jobLocation,
                    double annualSalary, double signingBonus, int stockAmount, double stockPriceCurrent) {

        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.jobLocation = jobLocation;
        this.annualSalary = annualSalary;
        this.signingBonus = signingBonus;
        this.stockAmount = stockAmount;
        this.stockPriceCurrent = stockPriceCurrent;
    }

    public String getCompanyName() {

        return companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public double getAnnualSalary() {

        return annualSalary;
    }

    public double getSigningBonus() {
        return signingBonus;
    }

    public double getStockAmount() {
        return stockAmount;
    }

    public double getStockPriceCurrent() {
        return stockPriceCurrent;
    }

    public static double calculateTotalSalary(JobOffer jo) {
        return (jo.getAnnualSalary() + jo.getSigningBonus() + (jo.getStockAmount() * jo.getStockPriceCurrent()));
    }
}




