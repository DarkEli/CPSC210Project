package persistence;

import model.City;
import model.CityList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderCityListTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReaderCityList reader = new JsonReaderCityList("./data/noSuchFile.json");
        try {
            CityList cityList = reader.readCityList();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCityList() {
        JsonReaderCityList reader = new JsonReaderCityList("./data/testReaderEmptyCityList.json");
        try {
            CityList cityList = reader.readCityList();
            assertEquals(0, cityList.cityListToJson().length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    @Test
    void testReaderGeneralWorkRoom() {
        JsonReaderCityList reader = new JsonReaderCityList("./data/testReaderCityListOneCity.json");
        try {
            CityList cityList = reader.readCityList();
            List<City> cities = cityList.getCityList();
            assertEquals(1, cities.size());
            checkCity("New York", "USA", 1000, cities.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }



}
