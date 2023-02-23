package model;

public class City {

    private static String cityName;
    private static String countryName;
    private static double livingExpensesAveragePerMonth;

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

//    City Vancouver = new City("Vancouver", "Canada",
//            4000, "CAD");
//
//    City Toronto = new City("Toronto", "Canada",
//            2600, "CAD");
//
//    City NewYork = new City("New York", "United States",
//            10000, "USD");

}
