package model;

public class City {

    public static String NameCity;
    public static String countryName;
    public static int livingExpensesAveragePerMonth;

    public City (String NameCity, String countryName,
                 int livingExpensesAveragePerMonth) {
        this.NameCity = NameCity;
        this.countryName = countryName;
        this.livingExpensesAveragePerMonth = livingExpensesAveragePerMonth;
    }

    public double getLivingExpenses() {
        return livingExpensesAveragePerMonth;
    }

    public String getNameCity() {return NameCity;}

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
