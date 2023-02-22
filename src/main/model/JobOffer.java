package model;

public class JobOffer {

    public static String CompanyName;
    public static String JobPosition;
    public static String JobLocation;
    public static double AnnualSalary;
    public static double SigningBonus;
    public static double StockAmount;
    public static double StockPriceCurrent;

    public JobOffer(String CompanyName, String JobPosition, String JobLocation,
                    double AnnualSalary, double SigningBonus, double StockAmount, double StockPriceCurrent) {

        JobOffer.CompanyName = CompanyName;
        JobOffer.JobPosition = JobPosition;
        JobOffer.JobLocation = JobLocation;
        JobOffer.AnnualSalary = AnnualSalary;
        JobOffer.SigningBonus = SigningBonus;
        JobOffer.StockAmount = StockAmount;
        JobOffer.StockPriceCurrent = StockPriceCurrent;

    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getJobPosition() {return JobPosition; }

    public String getJobLocation() {return JobLocation; }

    public double getAnnualSalary() {
        return AnnualSalary;
    }

    public double getSigningBonus() {
        return SigningBonus;
    }

    public double getStockAmount() {
        return StockAmount;
    }

    public double getStockPriceCurrent() {
        return StockPriceCurrent;
    }
}




