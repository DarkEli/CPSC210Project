package model;

import org.json.JSONObject;
import persistence.WritableObject;

public class JobOffer implements WritableObject {

    private String companyName;
    private String jobPosition;
    private String jobLocation;
    private double annualSalary;
    private double signingBonus;
    private int stockAmount;
    private double stockPriceCurrent;


    //REQUIRES: annualSalary, signingBonus, stockAmount, stockPriceCurrent must be >= 0
    //EFFECTS: Construct the JobOffer with company name, job position/title, job location,
    // annual salary, signing bonus, stock amount and current stock price
    // For annual salary, signing bonus, stock amount and current stock price, it must be positive number (int/ double)
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


    //EFFECTS: return the company name that gives out the JobOffer
    public String getCompanyName() {
        return companyName;
    }

    //EFFECTS: return the job title/ job position in the JobOffer
    public String getJobPosition() {
        return jobPosition;
    }


    //EFFECTS: return the job location of the job in the JobOffer
    public String getJobLocation() {
        return jobLocation;
    }


    //EFFECTS: return the annual salary of the JobOffer
    public double getAnnualSalary() {
        return annualSalary;
    }


    //EFFECTS: return the signing bonus that the Job Offer provides
    public double getSigningBonus() {
        return signingBonus;
    }



    //EFFECTS: return the stock amount that the Job Offer provides
    public double getStockAmount() {
        return stockAmount;
    }


    //EFFECTS: return the current stock price
    public double getStockPriceCurrent() {
        return stockPriceCurrent;
    }


    //REQUIRES: JobOffer
    //EFFECTS: calculate the total salary of the JobOffer
    //(Sum up Annual Salary + Signing Bonus + StockAmount * Current Stock Price)
    public static double calculateTotalSalary(JobOffer jo) {
        return (jo.getAnnualSalary() + jo.getSigningBonus() + (jo.getStockAmount() * jo.getStockPriceCurrent()));
    }


    //EFFECTS: turn JobOffer into a JSON object
    @Override
    public JSONObject objectToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("companyName", companyName);
        jsonObject.put("jobPosition", jobPosition);
        jsonObject.put("jobLocation", jobLocation);
        jsonObject.put("annualSalary", annualSalary);
        jsonObject.put("signingBonus", signingBonus);
        jsonObject.put("stockAmount", stockAmount);
        jsonObject.put("stockPriceCurrent", stockPriceCurrent);
        return jsonObject;
    }
}




