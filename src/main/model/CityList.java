package model;

import org.json.JSONObject;

import org.json.JSONArray;
import persistence.WritableObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    // EFFECTS: returns cityList as a JSON array
    public JSONArray cityListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (City city : cityList) {
            jsonArray.put(city.objectToJson());
        }

        return jsonArray;
    }

    //EFFECTS: turns the cityList into a JSON Object
    @Override
    public JSONObject objectToJson() {
        JSONObject json = new JSONObject();
        json.put("cityList", cityListToJson());
        return json;
    }

    public List<City> getCityList() {
        return Collections.unmodifiableList(cityList);
    }


}
