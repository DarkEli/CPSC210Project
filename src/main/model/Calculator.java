package model;

import static model.CityList.cityList;

public class Calculator {

    public static double CalculateTotalSalary(JobOffer jo) {
        return (jo.getAnnualSalary() + jo.getSigningBonus() + (jo.getStockAmount() * jo.getStockPriceCurrent()));
    }

    //public static double CityLivingCostUSD(String city) {
    //    if (city.currencyUnit.equals("USD")) {
    //        return city.livingExpensesAveragePerMonth;
    //    } else {
    //        return (city.livingExpensesAveragePerMonth * 0.74);
    //    }
    //}

    public static double CityLivingCost(City city) {
        double LivingCost = 0;
        if (city.getCountryName().equals("CA")) {
            LivingCost = city.getLivingExpenses() * 0.74 ;
        }
        else if (city.getCountryName().equals("USA")) {
            LivingCost = city.getLivingExpenses();
        }
        return LivingCost;
    }

    public static double CalculateDisposableIncome(JobOffer jo, City city) {
        double di = CalculateTotalSalary(jo) - CityLivingCost(city);
        return di;
    }

}