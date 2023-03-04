package persistence;

import model.JobOfferList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderJobOfferListTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderJobOfferList reader = new JsonReaderJobOfferList("./data/noSuchFile.json");
        try {
            JobOfferList jobOfferList = reader.readJobOfferList();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyJobOfferList() {
        JsonReaderJobOfferList reader = new JsonReaderJobOfferList("./data/testReaderEmptyJobOfferList.json");
        try {
            JobOfferList jobOfferList = reader.readJobOfferList();
            assertEquals(0, jobOfferList.jobOfferListToJson().length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderJobOfferListOneJobOffer() {
        JsonReaderJobOfferList reader = new JsonReaderJobOfferList("./data/testReaderJobOfferListOneJobOffer.json");
        try {
            JobOfferList jobOfferList = reader.readJobOfferList();
            assertEquals(1, jobOfferList.jobOfferListToJson().length());
            checkJobOffer("Google", "Product Manager", "New York City",
                    10000, 1000,100,100,
                    jobOfferList.getJobOfferList().get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
