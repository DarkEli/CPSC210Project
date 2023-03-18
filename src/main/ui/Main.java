package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//For the Main class, I (Elliott Au) took reference of the TellerApp project and the JSON Workroom sample project
// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//Link of the Workroom project: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class Main extends JFrame implements ActionListener {

    static JButton Quit;
    static JButton SaveCity;
    static JButton SaveJob;
    static JButton LoadCity;
    static JButton LoadJob;
    static JButton AddJob;
    static JButton AddCity;
    static JButton ShowAllJobs;
    static JButton ShowAllCities;

    public static void main(String[] args) {

        JFrame frame = new JFrame("YourJobComparator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

        Quit = new JButton();
        Quit.setBounds(50, 50, 70,40);
        Quit.setText("Quit");
        frame.add(Quit);

        LoadJob = new JButton();
        LoadJob.setBounds(50, 120, 70,40);
        LoadJob.setText("LoadJob");
        frame.add(LoadJob);

        SaveJob = new JButton();
        SaveJob.setBounds(50, 160, 70,40);
        SaveJob.setText("SaveJob");
        frame.add(SaveJob);

        AddJob = new JButton();
        AddJob.setBounds(50,200,70,40);
        AddJob.setText("AddJob");
        frame.add(AddJob);


        LoadCity = new JButton();
        LoadCity.setBounds(50, 240, 70,40);
        LoadCity.setText("LoadCity");
        frame.add(LoadCity);

        SaveCity = new JButton();
        SaveCity.setBounds(50,280, 70,40);
        SaveCity.setText("SaveCity");
        frame.add(SaveCity);

        AddCity = new JButton();
        AddCity.setBounds(50, 320, 70,40);
        AddCity.setText("AddCity");
        frame.add(AddCity);



        try {
            new JobOfferComparatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== Quit) {
            System.out.println("YOOO");
        }
    }
}