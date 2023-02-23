package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.JobOffer.calculateTotalSalary;
import static org.junit.jupiter.api.Assertions.*;

public class JobOfferTest {


    JobOffer jobOffer;

    @BeforeEach
    public void setup() {
        jobOffer = new JobOffer("GS", "Software Developer", "Vancouver",
                10000, 50000, 100, 256.3);
    }

    @Test
    public void TestCalculateTotalSalary() {
        assertEquals(85630, calculateTotalSalary(jobOffer));

    }
}


