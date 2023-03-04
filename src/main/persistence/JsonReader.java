package persistence;

import model.City;
import model.CityList;
import model.JobOffer;
import model.JobOfferList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads CityList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    public CityList readCityList() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCityList(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private CityList parseCityList(JSONObject jsonObject) {
        CityList cityList = new CityList();
        addCityToList(cityList, jsonObject);
        return cityList;
    }

    // MODIFIES: City
    // EFFECTS: parses CityList from JSON object
    private void addCityToList(CityList cityList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cityList");
        for (Object json : jsonArray) {
            JSONObject nextCity = (JSONObject) json;
            addCity(cityList, nextCity);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addCity(CityList cityList, JSONObject jsonObject) {
        String cityName = jsonObject.getString("cityName");
        String countryName = jsonObject.getString("countryName");
        double livingExpensesAveragePerMonth = jsonObject.getDouble("livingExpensesAveragePerMonth");
        City city = new City(cityName, countryName, livingExpensesAveragePerMonth);
        cityList.addCityToList(city);
    }

}
