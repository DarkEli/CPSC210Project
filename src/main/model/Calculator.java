package model;

import static model.CityList.cityList;

public class Calculator {

    public static double CalculateTotalSalary(JobOffer jo) {
        return jo.getAnnualSalary() + jo.getSigningBonus() + (jo.getStockAmount() * jo.getStockPriceCurrent()) ;
    }

    //public static double CityLivingCostUSD(String city) {
    //    if (city.currencyUnit.equals("USD")) {
    //        return city.livingExpensesAveragePerMonth;
    //    } else {
    //        return (city.livingExpensesAveragePerMonth * 0.74);
    //    }
    //}

    public static double CityLivingCost(String city) {
        double lc = 0;
        for (City c : cityList) {
            if (c.getNameCity().equals(city)) {
                lc = c.getLivingExpenses();
            }
        }
        return lc;
    }

    public static double CalculateDisposableIncome(JobOffer jo) {
        return (CalculateTotalSalary(jo) - CityLivingCost(jo.getJobLocation())) ;
    }

}