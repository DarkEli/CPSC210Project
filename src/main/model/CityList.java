package model;

import org.json.JSONObject;

import org.json.JSONArray;
import persistence.WritableObject;

import java.util.ArrayList;

public class CityList implements WritableObject {

    ArrayList<City> cityList;

    public CityList() {
        //EFFECTS: construct a list for saving the City info
        cityList = new ArrayList<>();
    }

    //REQUIRES: City
    //MODIFIES: this
    //EFFECTS: add the City to the list
    public void addCityToList(City city) {
        cityList.add(city);
    }



    //REQUIRES: String cityName, String countryName
    //MODIFIES: this
    //EFFECTS: remove the City from the list
    public void removeCityToList(String cityName, String countryName) {
        for (City c: cityList) {
            if (c.getCountryName().equals(countryName) && c.getCityName().equals(cityName)) {
                cityList.remove(c);
                break;
            }
        }
    }


    //EFFECTS: Show the City name in the list
    public String showCityName() {
        String cityName = "";
        for (City city : cityList) {
            cityName += city.getCityName() + "\n";
        }
        return cityName;
    }


    public JSONArray CityListToJson() {
        JSONArray ArrayToJson = new JSONArray();

        for (City city : cityList) {
            ArrayToJson.put(city.ObjectToJson());
        }

        return ArrayToJson;
    }

    @Override
    public JSONObject ObjectToJson() {
        JSONObject json = new JSONObject();
        json.put("cityList", CityListToJson());
        return json;
    }


}
