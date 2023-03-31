package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.WritableObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static model.JobOffer.calculateTotalSalary;


public class JobOfferList implements WritableObject {

    static ArrayList<JobOffer> jobOfferList;

    //EFFECTS: Construct a list for saving the JobOffer
    public JobOfferList() {
        jobOfferList = new ArrayList<>();
    }


    //REQUIRES: JobOffer
    //MODIFIES: this
    //EFFECTS: add the JobOffer to the list
    public void addJobOffer(JobOffer jo) {

        jobOfferList.add(jo);
    }


    //REQUIRES: String companyName, String jobPosition, String jobLocation
    //MODIFIES: this
    //EFFECTS: remove the JobOffer to the list

    public void removeJobOffer(String companyName, String jobPosition, String jobLocation) {
        for (JobOffer jo: jobOfferList) {
            if (jo.getCompanyName().equals(companyName) && jo.getJobPosition().equals(jobPosition)
                    && jo.getJobLocation().equals(jobLocation)) {
                jobOfferList.remove(jo);
                break;
            }
        }
        EventLog.getInstance().logEvent(new Event("Remove Job Offer."));
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
        EventLog.getInstance().logEvent(new Event("Job Offer with highest salary is found."));

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


    // EFFECTS: returns JobOfferList as a JSON array
    public JSONArray jobOfferListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (JobOffer jobOffer : jobOfferList) {
            jsonArray.put(jobOffer.objectToJson());
        }

        return jsonArray;
    }


    //EFFECTS: turns JobOfferList into a JSON object
    @Override
    public JSONObject objectToJson() {
        JSONObject json = new JSONObject();
        json.put("jobOfferList", jobOfferListToJson());
        return json;
    }

    // EFFECTS: returns an unmodifiable list of JobOffer (returns JobOfferList)
    public List<JobOffer> getJobOfferList() {
        EventLog.getInstance().logEvent(new Event("Get JobOfferList."));
        return Collections.unmodifiableList(jobOfferList);
    }
}
