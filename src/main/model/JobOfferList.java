package model;

import java.util.ArrayList;


public class JobOfferList {
    String c;
    double d;
    String e;

    ArrayList<JobOffer> JobOfferList = new ArrayList<>();

    public void addJobOffer(JobOffer jo) {
        JobOfferList.add(jo);
    }

    public void removeJobOffer(JobOffer jo) {JobOfferList.remove(jo); }

    public String maxSalaryJobOffer() {
        double a = 0;
        for (JobOffer jo: JobOfferList) {
            if (Calculator.CalculateTotalSalary(jo) > a) {
                a = Calculator.CalculateTotalSalary(jo);
                c = jo.getCompanyName();
                d = Calculator.CalculateTotalSalary(jo);
                e = jo.getJobPosition();
            }
        }
        return "Job Offer with Max Salary: " + e + " at " + c + "\n" + "Total Annual Salary: " + d;
    }
}
