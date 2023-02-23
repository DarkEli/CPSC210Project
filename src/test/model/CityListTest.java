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
    public void TestConstructor() {
        assertEquals(0, cityList.cityList.size());
    }

    @Test
    public void TestaddCityToListOneCity() {
        cityList.addCityToList(Vancouver);
        assertEquals(1, cityList.cityList.size());
    }

    @Test
    public void TestaddCityToListMultipleCity() {
        cityList.addCityToList(Vancouver);
        assertEquals(1, cityList.cityList.size());

        cityList.addCityToList(Toronto);
        assertEquals(2, cityList.cityList.size());

        cityList.addCityToList(NewYork);
        assertEquals(3, cityList.cityList.size());

    }
}
