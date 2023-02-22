package ui;

import model.City;
import model.CityList;
import model.JobOffer;
import model.JobOfferList;

import java.util.Scanner;

public class JobOfferComparatorApp {
    private JobOffer jobOffer;
    private JobOfferList jobOfferList;
    private Scanner input;
    private City city;
    private CityList cityList;


    // EFFECTS: runs the teller application
    public JobOfferComparatorApp() {
        runComparator();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runComparator() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command)  {
        if (command.equals("a")) {
            addJobOffer();
        } else if (command.equals("r")) {
            removeJobOffer();
        } else if (command.equals("f")) {
            findBestJobOffer();
        } else if (command.equals("c")) {
            addCityInfo();
        } else {
            System.out.println("Not a valid input...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        jobOfferList = new JobOfferList();
        cityList = new CityList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Job Offer");
        System.out.println("\tr -> Remove Job Offer");
        System.out.println("\tf -> Find the Best Job Offer");
        System.out.println("\tc -> Add City Info");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: adds Job Offer to the JobOfferList
    private void addJobOffer() {

        String CompanyName;
        String JobPosition;
        String JobLocation;
        double AnnualSalary;
        double SigningBonus;
        double StockAmount;
        double StockPriceCurrent;
        System.out.print("Add Job Offer");

        System.out.println("Input your job offer");

        System.out.println("Please input the Company name");

        System.out.println("Please input the job position");

        System.out.println("Please input your annual salary");

        System.out.println("Please input your signing bonus");

        System.out.println("Please input the amount of stocks provided");

        System.out.println("Please input the current stock price");

    }


    // MODIFIES: this
    // EFFECTS: removes Job Offer from the JobOfferList
    private void removeJobOffer() {
        System.out.println("Remove Job Offer");
        System.out.println("Please input which job offer you would like to remove");

    }

    // MODIFIES: this
    // EFFECTS: finds the best Job Offer in the JobOfferList
    private void findBestJobOffer() {
        System.out.println("Find the Best Job Offer");

    }

    private void addCityInfo() {
        System.out.println("Add city information: City Name, Country Name, " +
                "Living Expenses with rent per month (for 1 person only)");

        System.out.println("Please input the name of the City");

        System.out.println("Please input the country (USA or CA)");

        System.out.println("Please input the living expenses with rent per month (for 1 person only)");
    }


}

