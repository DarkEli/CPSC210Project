package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    City Vancouver;
    JSONObject jsonObject;


    @BeforeEach
    public void setup() {
        Vancouver = new City("Vancouver", "CA", 4000);

        jsonObject = new JSONObject();
        jsonObject.put("cityName", "Vancouver");
        jsonObject.put("countryName", "CA");
        jsonObject.put("livingExpensesAveragePerMonth", 4000);

    }

    @Test
    public void TestgetCityName() {
        assertEquals("Vancouver", Vancouver.getCityName());
    }

    @Test
    public void TestgetCountryName() {
        assertEquals("CA", Vancouver.getCountryName());

    }

    @Test
    public void TestgetLivingExpensesAveragePerMonth() {
        assertEquals(4000, Vancouver.getLivingExpenses());
    }

    @Test
    public void testObjectToJson() {
        assertEquals("Vancouver", jsonObject.getString("cityName"));
        assertEquals("CA", jsonObject.getString("countryName"));
        assertEquals(4000, jsonObject.getDouble("livingExpensesAveragePerMonth"));



    }
}
