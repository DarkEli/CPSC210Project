package model;

public class JobOffer {

    public static String CompanyName;
    public static String JobPosition;
    public static String JobLocation;
    public static int AnnualSalary;
    public static int SigningBonus;
    public static int StockAmount;
    public static int StockPriceCurrent;

    public JobOffer(String CompanyName, String JobPosition, String JobLocation,
                    int AnnualSalary, int SigningBonus, int StockAmount, int StockPriceCurrent) {

        this.CompanyName = CompanyName;
        this.JobPosition = JobPosition;
        this.JobLocation = JobLocation;
        this.AnnualSalary = AnnualSalary;
        this.SigningBonus = SigningBonus;
        this.StockAmount = StockAmount;
        this.StockPriceCurrent = StockPriceCurrent;

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




