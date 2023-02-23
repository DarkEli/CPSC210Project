package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    City Vancouver;

    @BeforeEach
    public void setup() {
        Vancouver = new City("Vancouver", "CA", 4000);

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
}
