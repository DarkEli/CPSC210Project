package model;

public class City {

    public static String NameCity;
    public static String countryName;
    public static int livingExpensesAveragePerMonth;
    public static String currencyUnit;

    public City (String NameCity, String countryName,
                 int livingExpensesAveragePerMonth, String currencyUnit) {
        this.NameCity = NameCity;
        this.countryName = countryName;
        this.livingExpensesAveragePerMonth = livingExpensesAveragePerMonth;
        this.currencyUnit = currencyUnit;
    }

    public double getLivingExpenses() {
        return livingExpensesAveragePerMonth;
    }

    public String getNameCity() {return NameCity;}

    public String getCurrencyUnit() {return currencyUnit; }

    public String getCountryName() {return countryName; }

//    City Vancouver = new City("Vancouver", "Canada",
//            4000, "CAD");
//
//    City Toronto = new City("Toronto", "Canada",
//            2600, "CAD");
//
//    City NewYork = new City("New York", "United States",
//            10000, "USD");

}
