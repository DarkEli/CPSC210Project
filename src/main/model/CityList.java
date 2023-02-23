package model;

import java.util.ArrayList;

public class CityList {

    static ArrayList<City> cityList = new ArrayList<>();

    public void addCityToList(City city) {
        cityList.add(city);
    }

    public void removeCityToList(City city) {
        cityList.remove(city);
    }

}
