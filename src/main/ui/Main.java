package ui;

import java.io.FileNotFoundException;

//For the Main class, I (Elliott Au) took reference of the TellerApp project and the JSON Workroom sample project
// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//Link of the Workroom project: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class Main {
    public static void main(String[] args) {
        try {
            new JobOfferComparatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}