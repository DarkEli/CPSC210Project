package model;

public class City {

    private String cityName;
    private String countryName;
    private double livingExpensesAveragePerMonth;

    public City(String cityName, String countryName, double livingExpensesAveragePerMonth) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.livingExpensesAveragePerMonth = livingExpensesAveragePerMonth;
    }

    public double getLivingExpenses() {
        return livingExpensesAveragePerMonth;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }


}
