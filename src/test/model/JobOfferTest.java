package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.JobOffer.calculateTotalSalary;
import static org.junit.jupiter.api.Assertions.*;

public class JobOfferTest {

    JobOffer jobOffer;
    JSONObject jsonObject;

    @BeforeEach
    public void setup() {
        jobOffer = new JobOffer("GS", "Software Developer", "Vancouver",
                10000, 50000, 100, 256.3);

        jsonObject = new JSONObject();
        jsonObject.put("companyName", "GS");
        jsonObject.put("jobPosition", "Software Developer");
        jsonObject.put("jobLocation", "Vancouver");
        jsonObject.put("annualSalary", 10000);
        jsonObject.put("signingBonus", 50000);
        jsonObject.put("stockAmount", 100);
        jsonObject.put("stockPriceCurrent", 256.3);
    }

    @Test
    public void TestCalculateTotalSalary() {
        assertEquals(85630, calculateTotalSalary(jobOffer));

    }

    @Test
    public void TestgetCompanyName() {
        assertEquals("GS",jobOffer.getCompanyName());
    }

    @Test
    public void TestgetJobPosition() {
        assertEquals("Software Developer", jobOffer.getJobPosition());
    }

    @Test
    public void TestgetJobLocation() {
        assertEquals("Vancouver", jobOffer.getJobLocation());
    }

    @Test
    public void TestObjectToJson() {
        assertEquals("GS", jsonObject.getString("companyName"));
        assertEquals("Software Developer", jsonObject.getString("jobPosition"));
        assertEquals("Vancouver",jsonObject.getString("jobLocation"));
        assertEquals(10000, jsonObject.getDouble("annualSalary"));
        assertEquals(50000, jsonObject.getDouble("signingBonus"));
        assertEquals(100, jsonObject.getInt("stockAmount"));
        assertEquals(256.3, jsonObject.getDouble("stockPriceCurrent"));
    }


}


