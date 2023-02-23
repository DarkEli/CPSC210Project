package model;

public class JobOffer {

    private static String companyName;
    private static String jobPosition;
    private static String jobLocation;
    private static double annualSalary;
    private static double signingBonus;
    private static int stockAmount;
    private static double stockPriceCurrent;

    public JobOffer(String companyName, String jobPosition, String jobLocation,
                    double annualSalary, double signingBonus, int stockAmount, double stockPriceCurrent) {

        JobOffer.companyName = companyName;
        JobOffer.jobPosition = jobPosition;
        JobOffer.jobLocation = jobLocation;
        JobOffer.annualSalary = annualSalary;
        JobOffer.signingBonus = signingBonus;
        JobOffer.stockAmount = stockAmount;
        JobOffer.stockPriceCurrent = stockPriceCurrent;

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




