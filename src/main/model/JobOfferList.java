package model;

import java.util.ArrayList;

import static model.JobOffer.calculateTotalSalary;


public class JobOfferList {

    ArrayList<JobOffer> jobOfferList = new ArrayList<>();

    public void addJobOffer(JobOffer jo) {
        jobOfferList.add(jo);
    }

    public void removeJobOffer(JobOffer jo) {
        jobOfferList.remove(jo);
    }

    public String maxSalaryJobOffer() {
        double max = 0;
        String jobMaxSalaryCompanyName = null;
        String jobMaxSalaryJobPosition = null;
        max = calculateTotalSalary(jobOfferList.get(0));
        jobMaxSalaryCompanyName = jobOfferList.get(0).getCompanyName();
        jobMaxSalaryJobPosition = jobOfferList.get(0).getJobPosition();
        for (JobOffer jo: jobOfferList) {
            if (calculateTotalSalary(jo) > max) {
                max = calculateTotalSalary(jo);
                jobMaxSalaryCompanyName = jo.getCompanyName();
                jobMaxSalaryJobPosition = jo.getJobPosition();
            }
        }
        return "The best job offer is working at " + jobMaxSalaryCompanyName
                + " as a " + jobMaxSalaryJobPosition + " with " + max + " as annual salary";
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
