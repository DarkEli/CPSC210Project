package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JobOfferListTest {

    JobOffer jobOffer1;
    JobOffer jobOffer2;
    JobOffer jobOffer3;
    JobOfferList jobOfferList1;

    @BeforeEach
    public void setup() {
        jobOfferList1 = new JobOfferList();
        jobOffer1 = new JobOffer("Google", "Product Manager", "New York",
                10000, 10000, 1000, 256.3);
        jobOffer2 = new JobOffer("Microsoft", "Software Developer", "Vancouver",
                20000, 5000, 100, 100);
        jobOffer3 = new JobOffer("Apple", "Software Developer", "Palo Alto",
                15000, 5000, 120, 130);
    }

    @Test
    public void TestConstructor() {
        assertEquals(0, jobOfferList1.jobOfferList.size());

    }

    @Test
    public void TestaddJobOfferOneJobOffer() {

        jobOfferList1.addJobOffer(jobOffer1);

        assertEquals(1, jobOfferList1.jobOfferList.size());
    }

    @Test
    public void TestaddJobOfferMultipleJobOffer() {

        jobOfferList1.addJobOffer(jobOffer1);
        assertEquals(1, jobOfferList1.jobOfferList.size());

        jobOfferList1.addJobOffer(jobOffer2);
        assertEquals(2, jobOfferList1.jobOfferList.size());

        jobOfferList1.addJobOffer(jobOffer3);
        assertEquals(3, jobOfferList1.jobOfferList.size());

    }

    @Test
    public void TestremoveJobOfferOneJobOffer() {
        jobOfferList1.addJobOffer(jobOffer1);
        assertEquals(1, jobOfferList1.jobOfferList.size());


        assertEquals("Google", jobOfferList1.jobOfferList.get(0).getCompanyName());
        assertEquals("Product Manager", jobOfferList1.jobOfferList.get(0).getJobPosition());
        assertEquals("New York", jobOfferList1.jobOfferList.get(0).getJobLocation());
        assertEquals(10000, jobOfferList1.jobOfferList.get(0).getAnnualSalary());
        assertEquals(10000, jobOfferList1.jobOfferList.get(0).getSigningBonus());
        assertEquals(1000, jobOfferList1.jobOfferList.get(0).getStockAmount());
        assertEquals(256.3, jobOfferList1.jobOfferList.get(0).getStockPriceCurrent());


        jobOfferList1.removeJobOffer(jobOffer1.getCompanyName(), jobOffer1.getJobPosition(),
                jobOffer1.getJobLocation(), jobOffer1.getAnnualSalary(), jobOffer1.getSigningBonus(),
                (int) jobOffer1.getStockAmount(), jobOffer1.getStockPriceCurrent());
        assertEquals(0, jobOfferList1.jobOfferList.size());

    }

    @Test
    public void TestremoveJobOfferMultipleJobOffer() {
        jobOfferList1.addJobOffer(jobOffer1);
        jobOfferList1.addJobOffer(jobOffer2);
        jobOfferList1.addJobOffer(jobOffer3);

        jobOfferList1.removeJobOffer(jobOffer1.getCompanyName(), jobOffer1.getJobPosition(),
                jobOffer1.getJobLocation(), jobOffer1.getAnnualSalary(), jobOffer1.getSigningBonus(),
                (int) jobOffer1.getStockAmount(), jobOffer1.getStockPriceCurrent());
        assertEquals(2, jobOfferList1.jobOfferList.size());

        jobOfferList1.removeJobOffer(jobOffer1.getCompanyName(), jobOffer1.getJobPosition(),
                jobOffer1.getJobLocation(), jobOffer1.getAnnualSalary(), jobOffer1.getSigningBonus(),
                (int) jobOffer1.getStockAmount(), jobOffer1.getStockPriceCurrent());
        assertEquals(2, jobOfferList1.jobOfferList.size());

        jobOfferList1.removeJobOffer(jobOffer2.getCompanyName(), jobOffer2.getJobPosition(),
                jobOffer2.getJobLocation(), jobOffer2.getAnnualSalary(), jobOffer2.getSigningBonus(),
                (int) jobOffer2.getStockAmount(), jobOffer2.getStockPriceCurrent());
        assertEquals(1, jobOfferList1.jobOfferList.size());

        jobOfferList1.removeJobOffer(jobOffer3.getCompanyName(), jobOffer3.getJobPosition(),
                jobOffer3.getJobLocation(), jobOffer3.getAnnualSalary(), jobOffer3.getSigningBonus(),
                (int) jobOffer3.getStockAmount(), jobOffer3.getStockPriceCurrent());
        assertEquals(0, jobOfferList1.jobOfferList.size());


    }

    @Test
    public void testmaxSalaryJobOfferOneOffer() {
        jobOfferList1.addJobOffer(jobOffer1);
        assertEquals("The best job offer is working at Google as a Product Manager with "
                + "276300.0 as annual salary", jobOfferList1.maxSalaryJobOffer());

    }

    @Test
    public void testmaxSalaryJobOfferMultipleOffer() {
        jobOfferList1.addJobOffer(jobOffer2);
        jobOfferList1.addJobOffer(jobOffer1);
        assertEquals("The best job offer is working at Google as a Product Manager with "
                + "276300.0 as annual salary", jobOfferList1.maxSalaryJobOffer());

        jobOfferList1.addJobOffer(jobOffer3);
        assertEquals("The best job offer is working at Google as a Product Manager with "
                + "276300.0 as annual salary", jobOfferList1.maxSalaryJobOffer());

    }

    @Test
    public void testshowJobOfferCompanyAndPositionOneOffer() {
        jobOfferList1.addJobOffer(jobOffer1);
        assertEquals("Google : Product Manager in New York\n",
                jobOfferList1.showJobOfferCompanyAndPosition());


    }

    @Test
    public void testshowJobOfferCompanyAndPositionMultipleOffer() {
        jobOfferList1.addJobOffer(jobOffer1);
        jobOfferList1.addJobOffer(jobOffer2);
        jobOfferList1.addJobOffer(jobOffer3);
        assertEquals("Google : Product Manager in New York\n" +
                        "Microsoft : Software Developer in Vancouver\n" +
                        "Apple : Software Developer in Palo Alto\n",
                jobOfferList1.showJobOfferCompanyAndPosition());


    }


}
