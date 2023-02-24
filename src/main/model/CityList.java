package model;

import java.util.ArrayList;

public class CityList {

    //EFFECTS: construct a list for saving the City info
    ArrayList<City> cityList = new ArrayList<>();


    //REQUIRES: City
    //MODIFIES: this
    //EFFECTS: add the City to the list
    public void addCityToList(City city) {
        cityList.add(city);
    }



    //REQUIRES: City
    //MODIFIES: this
    //EFFECTS: remove the City from the list
    public void removeCityToList(City city) {
        cityList.remove(city);
    }


    //EFFECTS: Show the City name in the list
    public String showCityName() {
        String cityName = "";
        for (City city : cityList) {
            cityName += city.getCityName()+ "\n";
        }
        return cityName;
    }

}
