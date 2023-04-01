package ui;

import model.*;

import persistence.JsonReaderCityList;
import persistence.JsonReaderJobOfferList;
import persistence.JsonWriterCityList;
import persistence.JsonWriterJobOfferList;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static model.JobOffer.calculateTotalSalary;
import static ui.Main.CityDefaultTable;
import static ui.Main.JobOfferDefaultTable;

//For this class, I (Elliott Au) took reference of the TellerApp project and the JSON Workroom sample project
//// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//Link of the Workroom project: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JobOfferComparatorApp {
    private JobOffer jobOffer;
    private static JobOfferList jobOfferList;
    private static Scanner input;
    private City city;
    private static CityList cityList;
    static String companyName;
    static String jobPosition;
    static String jobLocation;
    static double annualSalary;
    static double signingBonus;
    static int stockAmount;
    static double stockPriceCurrent;
    static String cityName;
    static String countryName;
    static double livingExpenses;
    private static JsonWriterCityList jsonWriterCityList;
    private static JsonReaderCityList jsonReaderCityList;
    private static JsonWriterJobOfferList jsonWriter1;
    private static JsonReaderJobOfferList jsonReader1;
    private static final String JSON_STORE1 = "./data/normalCityList.json";
    private static final String JSON_STORE2 = "./data/normalJobOfferList.json";

    //EFFECTS: runs the teller application
    public JobOfferComparatorApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        cityList = new CityList();
        jsonWriterCityList = new JsonWriterCityList(JSON_STORE1);
        jsonWriter1 = new JsonWriterJobOfferList(JSON_STORE2);
        jsonReaderCityList = new JsonReaderCityList(JSON_STORE1);
        jsonReader1 = new JsonReaderJobOfferList(JSON_STORE2);
        runComparator();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public static void runComparator() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("0")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: this
    // EFFECTS: processes user command
    private static void processCommand(String command) {
        if (command.equals("1")) {
            addJobOffer();
        } else if (command.equals("2")) {
            removeJobOffer();
        } else if (command.equals("3")) {
            showJobOfferList();
        } else if (command.equals("4")) {
            findBestJobOffer();
        } else if (command.equals("5")) {
            calTotalSalaryConsole();
        } else if (command.equals("6")) {
            addCityInfo();
        } else if (command.equals("7")) {
            removeCityInfo();
        } else if (command.equals("8")) {
            showCityList();
        } else if (command.equals("9")) {
            saveCityList();
        } else if (command.equals("10")) {
            loadCityList();
        } else if (command.equals("11")) {
            saveJobOfferList();
        } else if (command.equals("12")) {
            loadJobOfferList();
        } else {
            System.out.println("Not a valid input...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private static void init() {
        jobOfferList = new JobOfferList();
        cityList = new CityList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> Add Job Offer");
        System.out.println("\t2 -> Remove Job Offer");
        System.out.println("\t3 -> Show all JobOffers in the list");
        System.out.println("\t4 -> Find the Best Job Offer");
        System.out.println("\t5 -> Calculate the total annual salary of 1 Job Offer");
        System.out.println("\t6 -> Add City Info");
        System.out.println("\t7 -> Remove City Info");
        System.out.println("\t8 -> Show all cities in the list");
        System.out.println("\t9 -> Save CityList");
        System.out.println("\t10 -> Load CityList");
        System.out.println("\t11 -> Save JobOfferList");
        System.out.println("\t12 -> Load JobOfferList");
        System.out.println("\t0 -> Quit");

    }

    @SuppressWarnings("methodlength")
    // MODIFIES: JobOfferList
    // EFFECTS: Construct a Job Offer, adds that Job Offer to the JobOfferList
    public static void addJobOffer() {

        System.out.print("Add Job Offer");
        JOptionPane.showMessageDialog(null, "Add Job Offer");

        System.out.println("Input your job offer");
        JOptionPane.showMessageDialog(null, "Enter your job offer");

        System.out.println("Please input the Company name");
        companyName = JOptionPane.showInputDialog(null, "Enter Company's name: ");

        System.out.println("Please input the job position");
        jobPosition = JOptionPane.showInputDialog(null, "Enter job position: ");

        System.out.println("Please input the job location");
        jobLocation = JOptionPane.showInputDialog(null, "Enter job location: ");

        System.out.println("Please input your annual salary");
        annualSalary = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter annual salary: "));

        System.out.println("Please input your signing bonus");
        signingBonus = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter signing bonus: "));

        System.out.println("Please input the amount of stocks provided");
        stockAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter stock amount: "));

        System.out.println("Please input the current stock price");
        stockPriceCurrent = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter current stock price: "));

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        jobOfferList.addJobOffer(jobOffer);

        System.out.println("The Job Offer has been added to the list successfully!");
        JOptionPane.showMessageDialog(null,
                "The Job Offer has been added to the list successfully!");

    }


    @SuppressWarnings("methodlength")
    // MODIFIES: JobOfferList
    // EFFECTS: Construct a Job Offer, then removes that Job Offer from the JobOfferList
    public static void removeJobOffer() {

        System.out.println("Remove Job Offer");
        JOptionPane.showMessageDialog(null, "Remove Job Offer");

        System.out.println("Please input which job offer you would like to remove");
        JOptionPane.showMessageDialog(null, "Enter the job offer that you would like to remove");

        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");
        companyName = JOptionPane.showInputDialog(null, "Enter Company's name: ");

        System.out.println("Please input the job position");
        jobPosition = JOptionPane.showInputDialog(null, "Enter job position: ");

        System.out.println("Please input the job location");
        jobLocation = JOptionPane.showInputDialog(null, "Enter job location: ");

        System.out.println("Please input your annual salary");
        annualSalary = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter annual salary: "));

        System.out.println("Please input your signing bonus");
        signingBonus = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter signing bonus: "));

        System.out.println("Please input the amount of stocks provided");
        stockAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter stock amount: "));

        System.out.println("Please input the current stock price");
        stockPriceCurrent = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter current stock price: "));

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        jobOfferList.removeJobOffer(companyName, jobPosition, jobLocation);

        System.out.println("The Job Offer is removed from the list successfully!");
        JOptionPane.showMessageDialog(null, "The Job Offer is removed from the list successfully!");


    }


    // EFFECTS: find the best Job Offer in the JobOfferList
    public static void findBestJobOffer() {
        System.out.println("Find the Best Job Offer");
        System.out.println(jobOfferList.maxSalaryJobOffer());
        JOptionPane.showMessageDialog(null, jobOfferList.maxSalaryJobOffer());
    }


    @SuppressWarnings("methodlength")
    //EFFECTS: calculate the total salary of the JobOffer
    public static void calTotalSalaryConsole() {
        System.out.println("Calculate the total annual salary");
        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");
        companyName = JOptionPane.showInputDialog(null, "Enter Company's name: ");

        System.out.println("Please input the job position");
        jobPosition = JOptionPane.showInputDialog(null, "Enter job position: ");

        System.out.println("Please input the job location");
        jobLocation = JOptionPane.showInputDialog(null, "Enter job location: ");

        System.out.println("Please input your annual salary");
        annualSalary = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter annual salary: "));

        System.out.println("Please input your signing bonus");
        signingBonus = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter signing bonus: "));

        System.out.println("Please input the amount of stocks provided");
        stockAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter stock amount: "));

        System.out.println("Please input the current stock price");
        stockPriceCurrent = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter current stock price: "));

        JobOffer jobOffer = new JobOffer(companyName, jobPosition, jobLocation,
                annualSalary, signingBonus, stockAmount, stockPriceCurrent);

        System.out.println("The total annual salary of being a "
                + jobOffer.getJobPosition() + " at " + jobOffer.getCompanyName() + " in " + jobOffer.getJobLocation()
                + " is " + calculateTotalSalary(jobOffer));

        JOptionPane.showMessageDialog(null,
                "The total annual salary of being a "
                        + jobOffer.getJobPosition() + " at " + jobOffer.getCompanyName()
                        + " in " + jobOffer.getJobLocation() + " is " + calculateTotalSalary(jobOffer));

    }

    //MODIFIES: CityList
    //EFFECTS: add the City from the list
    public static void addCityInfo() {

        System.out.println("Add city information: City Name, Country Name, "
                + "Living Expenses with rent per month (for 1 person only)");
        JOptionPane.showMessageDialog(null,
                "Add city information: City Name, Country Name, "
                        + "Living Expenses with rent per month (for 1 person only)");

        System.out.println("Please input the name of the City");
        cityName = JOptionPane.showInputDialog(null, "Enter city name: ");

        System.out.println("Please input the country (USA or CA)");
        countryName = JOptionPane.showInputDialog(null, "Enter country name: ");

        System.out.println("Please input the living expenses with rent per month (for 1 person only)");
        livingExpenses = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter living expenses amount per month (including rent)"));

        City city = new City(cityName, countryName, livingExpenses);

        cityList.addCityToList(city);

        System.out.println("The city info is added successfully!");
        JOptionPane.showMessageDialog(null, "The city info is added successfully!");


    }

    //MODIFIES: CityList
    //EFFECTS: remove the City from the list
    public static void removeCityInfo() {

        System.out.println("Remove city information: City Name, Country Name, "
                + "Living Expenses with rent per month (for 1 person only)");
        JOptionPane.showMessageDialog(null,
                "Remove city information: City Name, Country Name, "
                        + "Living Expenses with rent per month (for 1 person only)");

        System.out.println("Please input the name of the City");
        cityName = JOptionPane.showInputDialog(null, "Enter city name: ");

        System.out.println("Please input the country (USA or CA)");
        countryName = JOptionPane.showInputDialog(null, "Enter country name: ");

        System.out.println("Please input the living expenses with rent per month (for 1 person only)");
        livingExpenses = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Enter living expenses amount per month (including rent)"));

        City city = new City(cityName, countryName, livingExpenses);

        cityList.removeCityToList(cityName, countryName);

        System.out.println("The city info is removed successfully!");
        JOptionPane.showMessageDialog(null, "The city info is removed successfully!");

    }

    //EFFECTS: Show the company name, job position and job location of the job offer
    public static void showJobOfferList() {
        System.out.println(jobOfferList.showJobOfferCompanyAndPosition());
        System.out.println("All Job Offers have been listed");

        JobOfferDefaultTable.setRowCount(0);
//        for (int i = 0; i < jobOfferList.getJobOfferList().size(); i++) {
//            String companyName = jobOfferList.getJobOfferList().get(i).getCompanyName();
//            String jobPosition = jobOfferList.getJobOfferList().get(i).getJobPosition();
//            String jobLocation = jobOfferList.getJobOfferList().get(i).getJobLocation();
//            double annualSalary = jobOfferList.getJobOfferList().get(i).getAnnualSalary();
//            double signingBonus = jobOfferList.getJobOfferList().get(i).getSigningBonus();
//            int stockAmount = jobOfferList.getJobOfferList().get(i).getStockAmount();
//            double stockPriceCurrent = jobOfferList.getJobOfferList().get(i).getStockPriceCurrent();
        for (JobOffer jobOffer : jobOfferList.getJobOfferList()) {
            String companyName = jobOffer.getCompanyName();
            String jobPosition = jobOffer.getJobPosition();
            String jobLocation = jobOffer.getJobLocation();
            double annualSalary = jobOffer.getAnnualSalary();
            double signingBonus = jobOffer.getSigningBonus();
            int stockAmount = jobOffer.getStockAmount();
            double stockPriceCurrent = jobOffer.getStockPriceCurrent();

            Object[] data = {companyName, jobPosition, jobLocation,
                    annualSalary, signingBonus, stockAmount, stockPriceCurrent};

            JobOfferDefaultTable.addRow(data);

        }

    }

    //EFFECTS: Show the name of the cities in the cityList
    public static void showCityList() {
        System.out.println(cityList.showCityName());
        System.out.println("All city names have been listed");

        CityDefaultTable.setRowCount(0);
//        for (int i = 0; i < cityList.getCityList().size(); i++) {
//            String cityName = cityList.getCityList().get(i).getCityName();
//            String countryName = cityList.getCityList().get(i).getCountryName();
//            double livingExpensesAveragePerMonth = cityList.getCityList().get(i).getLivingExpenses();
        for (City c: cityList.getCityList()) {
            String cityName = c.getCityName();
            String countryName = c.getCountryName();
            double livingExpensesAveragePerMonth = c.getLivingExpenses();

            Object[] data = {cityName, countryName, livingExpensesAveragePerMonth};

            CityDefaultTable.addRow(data);

        }
    }

    // EFFECTS: saves CityList to file
    public static void saveCityList() {
        try {
            jsonWriterCityList.open();
            jsonWriterCityList.writeCityList(cityList);
            jsonWriterCityList.close();
            System.out.println("Saved city list to " + JSON_STORE1);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE1);
        }

        JOptionPane.showMessageDialog(null, "City info is saved");

    }


    // EFFECTS: loads CityList from file
    public static void loadCityList() {
        try {
            cityList = jsonReaderCityList.readCityList();
            System.out.println("Loaded city list from " + JSON_STORE1);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE1);
        }
    }

    // EFFECTS: saves JobOfferList from file
    public static void saveJobOfferList() {
        try {
            jsonWriter1.open();
            jsonWriter1.writeJobOfferList(jobOfferList);
            jsonWriter1.close();
            System.out.println("Saved job offer list to " + JSON_STORE2);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE2);
        }

        JOptionPane.showMessageDialog(null, "Job Offer is saved");

    }


    // EFFECTS: loads JobOfferList from file
    public static void loadJobOfferList() {
        try {
            jobOfferList = jsonReader1.readJobOfferList();
            System.out.println("Loaded job offer list from " + JSON_STORE2);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE2);
        }
    }

}

