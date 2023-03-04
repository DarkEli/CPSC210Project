package persistence;

import model.JobOffer;
import model.JobOfferList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterJobOfferListTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JobOfferList jobOfferList = new JobOfferList();
            JsonWriterJobOfferList writer = new JsonWriterJobOfferList("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }


    @Test
    void testWriterEmptyWorkroom() {
        try {
            JobOfferList jobOfferList = new JobOfferList();
            JsonWriterJobOfferList writer = new
                    JsonWriterJobOfferList("./data/testWriterEmptyJobOfferList.json");
            writer.open();
            writer.writeJobOfferList(jobOfferList);
            writer.close();

            JsonReaderJobOfferList reader = new
                    JsonReaderJobOfferList("./data/testWriterEmptyJobOfferList.json");
            jobOfferList = reader.readJobOfferList();
            assertEquals(0, jobOfferList.jobOfferListToJson().length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }

    @Test
    void testWriterJobOfferListOneJobOffer() {
        try {
            JobOfferList jobOfferList = new JobOfferList();
            jobOfferList.addJobOffer(new JobOffer("Apple", "Software Developer",
                    "Palo Alto", 10001,2000,101,100));
            jobOfferList.addJobOffer(new JobOffer("Microsoft", "Product Manager",
                    "Vancouver", 10002, 2001, 102, 100));
            JsonWriterJobOfferList writer = new
                    JsonWriterJobOfferList("./data/testWriterJobOfferListOneJobOffer.json");
            writer.open();
            writer.writeJobOfferList(jobOfferList);
            writer.close();

            JsonReaderJobOfferList reader = new
                    JsonReaderJobOfferList("./data/testWriterJobOfferListOneJobOffer.json");
            jobOfferList = reader.readJobOfferList();
            List<JobOffer> jobOffers = jobOfferList.getJobOfferList();
            assertEquals(2, jobOffers.size());
            checkJobOffer("Apple", "Software Developer", "Palo Alto",
                    10001, 2000, 101, 100, jobOffers.get(0));
            checkJobOffer("Microsoft", "Product Manager", "Vancouver",
                    10002, 2001, 102, 100, jobOffers.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
