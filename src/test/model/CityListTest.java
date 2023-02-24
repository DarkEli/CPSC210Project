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

        cityList.removeCityToList(Vancouver);
        assertEquals(0, cityList.cityList.size());
    }

    @Test
    public void testremoveCityToListMultipleCity() {
        cityList.addCityToList(Vancouver);
        cityList.addCityToList(Toronto);
        cityList.addCityToList(NewYork);

        cityList.removeCityToList(Vancouver);
        assertEquals(2, cityList.cityList.size());

        cityList.removeCityToList(Vancouver);
        assertEquals(2, cityList.cityList.size());

        cityList.removeCityToList(NewYork);
        assertEquals(1, cityList.cityList.size());

        cityList.removeCityToList(Toronto);
        assertEquals(0, cityList.cityList.size());

    }

    @Test
    public void testshowCityNameOneCity() {
        cityList.addCityToList(Vancouver);

    }
}
