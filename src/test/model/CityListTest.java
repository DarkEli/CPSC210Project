package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    City Vancouver;
    City NewYork;
    City Toronto;
    CityList cityList;

    @BeforeEach
    public void setup() {
        Vancouver = new City("Vancouver", "CA", 4000);
        Toronto = new City("Toronto", "CA", 2600);
        NewYork = new City("New York", "US", 10000);
        cityList = new CityList();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, cityList.cityList.size());
    }

    @Test
    public void testaddCityToListOneCity() {
        cityList.addCityToList(Vancouver);
        assertEquals(1, cityList.cityList.size());
    }

    @Test
    public void testaddCityToListMultipleCity() {
        cityList.addCityToList(Vancouver);
        assertEquals(1, cityList.cityList.size());

        cityList.addCityToList(Toronto);
        assertEquals(2, cityList.cityList.size());

        cityList.addCityToList(NewYork);
        assertEquals(3, cityList.cityList.size());

    }

    @Test
    public void testremoveCityToListOneCity() {
        cityList.addCityToList(Vancouver);
        assertEquals(1, cityList.cityList.size());

        assertEquals("Vancouver", Vancouver.getCityName());
        assertEquals("CA", Vancouver.getCountryName());
        assertEquals(4000, Vancouver.getLivingExpenses());

        cityList.removeCityToList("Vancouver", "CA", 4000);
        assertEquals(0, cityList.cityList.size());
    }

    @Test
    public void testremoveCityToListMultipleCity() {
        cityList.addCityToList(Vancouver);
        cityList.addCityToList(Toronto);
        cityList.addCityToList(NewYork);

        cityList.removeCityToList("Vancouver", "CA", 4000);
        assertEquals(2, cityList.cityList.size());

        cityList.removeCityToList("Vancouver", "CA", 4000);
        assertEquals(2, cityList.cityList.size());

        cityList.removeCityToList("New York", "US", 10000);
        assertEquals(1, cityList.cityList.size());

        cityList.removeCityToList("Toronto", "CA", 2600);
        assertEquals(0, cityList.cityList.size());

    }

    @Test
    public void testshowCityNameOneCity() {
        cityList.addCityToList(Vancouver);

        assertEquals("Vancouver\n", cityList.showCityName());

    }

    @Test
    public void testshowCityNameMultipleCity() {
        cityList.addCityToList(Vancouver);
        cityList.addCityToList(Toronto);
        cityList.addCityToList(NewYork);

        assertEquals("Vancouver\nToronto\nNew York\n", cityList.showCityName());

    }



}
