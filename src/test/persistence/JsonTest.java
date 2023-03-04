package persistence;

import model.City;
import model.JobOffer;
import org.json.JSONArray;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {

    protected void checkCity(String cityName, String countryName, double livingExpensesAveragePerMonth, City city) {
        assertEquals(cityName, city.getCityName());
        assertEquals(countryName, city.getCountryName());
        assertEquals(livingExpensesAveragePerMonth, city.getLivingExpenses());
    }

    protected void checkJobOffer(String companyName, String jobPosition, String jobLocation
    , double annualSalary, double signingBonus, int stockAmount, double stockPriceCurrent, JobOffer jobOffer) {
        assertEquals(companyName, jobOffer.getCompanyName());
        assertEquals(jobPosition, jobOffer.getJobPosition());
        assertEquals(jobLocation, jobOffer.getJobLocation());
        assertEquals(annualSalary, jobOffer.getAnnualSalary());
        assertEquals(signingBonus, jobOffer.getSigningBonus());
        assertEquals(stockAmount, jobOffer.getStockAmount());
        assertEquals(stockPriceCurrent, jobOffer.getStockPriceCurrent());
    }
}
