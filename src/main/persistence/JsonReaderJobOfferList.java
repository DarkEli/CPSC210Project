package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


// Represents a reader that reads CityList from JSON data stored in file

public class JsonReaderJobOfferList {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderJobOfferList(String source) {
        this.source = source;
    }



    // EFFECTS: reads JobOfferList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public JobOfferList readJobOfferList() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseJobOfferList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses JobOfferList from JSON object and returns it
    private JobOfferList parseJobOfferList(JSONObject jsonObject) {
        JobOfferList jobOfferList = new JobOfferList();
        addJobToList(jobOfferList, jsonObject);
        return jobOfferList;
    }


    // MODIFIES: JobOfferList
    // EFFECTS: parses JobOfferList from JSON object and add the list to the JobOfferList
    private void addJobToList(JobOfferList jobOfferList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("jobOfferList");
        for (Object json : jsonArray) {
            JSONObject nextJobOffer = (JSONObject) json;
            addJobOffer(jobOfferList, nextJobOffer);
        }
    }


    // MODIFIES: JobOfferList
    // EFFECTS: parses JobOffer from JSON object and adds it to JobOfferList
    private void addJobOffer(JobOfferList jobOfferList, JSONObject jsonObject) {
        String companyName = jsonObject.getString("companyName");
        String jobPosition = jsonObject.getString("jobPosition");
        String jobLocation = jsonObject.getString("jobLocation");
        double annualSalary = jsonObject.getDouble("annualSalary");
        double signingBonus = jsonObject.getDouble("signingBonus");
        int stockAmount = jsonObject.getInt("stockAmount");
        double stockPriceCurrent = jsonObject.getDouble("stockPriceCurrent");
        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        jobOfferList.addJobOffer(jobOffer);
    }

}
