package model;

import java.util.ArrayList;

import static model.JobOffer.calculateTotalSalary;


public class JobOfferList {

    //EFFECTS: Construct a list for saving the JobOffer
    ArrayList<JobOffer> jobOfferList = new ArrayList<>();


    //REQUIRES: JobOffer
    //MODIFIES: this
    //EFFECTS: add the JobOffer to the list
    public void addJobOffer(JobOffer jo) {
        jobOfferList.add(jo);
    }


    //REQUIRES: JobOffer
    //MODIFIES: this
    //EFFECTS: remove the JobOffer to the list
    public void removeJobOffer(JobOffer jo) {
        jobOfferList.remove(jo);
    }


    //EFFECTS: Identifies the JobOffer with max (total) salary and return the message
    // that shows the full info of the offer
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


    //EFFECTS: Return a string that shows the job offer info
    // (Company that gives the JobOffer and the job position)
    public String showJobOfferCompanyAndPosition() {
        String jobOfferInfo = "";
        for (JobOffer jobOffer: jobOfferList) {
            jobOfferInfo += (jobOffer.getCompanyName() + " : " + jobOffer.getJobPosition() + " in "
                    + jobOffer.getJobLocation()) + "\n";
        }
        return jobOfferInfo;
    }
}
