package persistence;

import model.City;
import model.CityList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterCityListTest extends JsonTest{


    @Test
    void testWriterInvalidFile() {
        try {
            CityList cityList = new CityList();
            JsonWriterCityList writer = new JsonWriterCityList("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCityList() {
        try {
            CityList cityList = new CityList();
            JsonWriterCityList writer = new JsonWriterCityList("./data/testWriterEmptyCityList.json");
            writer.open();
            writer.writeCityList(cityList);
            writer.close();

            JsonReaderCityList reader = new JsonReaderCityList("./data/testWriterEmptyCityList.json");
            cityList = reader.readCityList();
            assertEquals(0, cityList.getCityList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterCityListOneCity() {
        try {
            CityList cityList = new CityList();
            cityList.addCityToList(new City("New York", "USA", 1000));
            cityList.addCityToList(new City("Palo Alto", "USA", 1001));
            JsonWriterCityList writer = new JsonWriterCityList("./data/testWriterCityListOneCity.json");
            writer.open();
            writer.writeCityList(cityList);
            writer.close();

            JsonReaderCityList reader = new JsonReaderCityList("./data/testWriterCityListOneCity.json");
            cityList = reader.readCityList();
            List<City> cities = cityList.getCityList();
            assertEquals(2, cities.size());
            checkCity("New York", "USA",1000, cities.get(0));
            checkCity("Palo Alto", "USA",1001, cities.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
