package model;

import java.util.ArrayList;


public class JobOfferList {

    ArrayList<JobOffer> jobOfferList = new ArrayList<>();

    public void addJobOffer(JobOffer jo) {
        jobOfferList.add(jo);
    }

    public void removeJobOffer(JobOffer jo) {
        jobOfferList.remove(jo);
    }

//    public String maxSalaryJobOffer() {
//        double a = 0;
//        for (JobOffer jo: JobOfferList) {
//            if (Calculator.CalculateTotalSalary(jo) > a) {
//                a = Calculator.CalculateTotalSalary(jo);
//                c = jo.getCompanyName();
//                d = Calculator.CalculateTotalSalary(jo);
//                e = jo.getJobPosition();
//            }
//        }
//        return "Job Offer with Max Salary: " + e + " at " + c + "\n" + "Total Annual Salary: " + d;
//    }
}
