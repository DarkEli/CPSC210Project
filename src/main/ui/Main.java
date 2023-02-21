package ui;

import model.City;
import model.CityList;
import model.JobOffer;
import model.JobOfferList;
import model.Calculator;

public class Main {
    public static void main(String[] args) {
        JobOffer jo1 = new JobOffer("GS", "Software Developer", "Vancouver",
                10000, 50000, 0,0);

        JobOffer jo2 = new JobOffer("MS", "Software Developer", "New York",
                100000, 500000, 0,0);

        JobOffer jo3 = new JobOffer("SS", "Software Developer", "New York",
                100000, 400000, 0,0);

        JobOfferList j1 = new JobOfferList();
        j1.addJobOffer(jo1);

        System.out.println(j1.maxSalaryJobOffer());

        City Vancouver = new City("Vancouver", "Canada",
                4000, "CAD");

        City Toronto = new City("Toronto", "Canada",
                2600, "CAD");

        City NewYork = new City("New York", "United States",
                10000, "USD");

        CityList CL1 = new CityList();

        CL1.addCityToList(Vancouver);
        CL1.addCityToList(Toronto);
        CL1.addCityToList(NewYork);

        System.out.println(Calculator.CityLivingCost("Vancouver"));

    }
}
