package ui;

import model.JobOffer;
import model.JobOfferList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import static ui.JobOfferComparatorApp.*;

//For the Main class, I (Elliott Au) took reference of the TellerApp project and the JSON Workroom sample project
// did some modifications by myself
//Link of the TellerApp project: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//Link of the Workroom project: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public abstract class Main extends JFrame implements ActionListener {

    static JButton Quit;
    static JButton SaveCity;
    static JButton SaveJob;
    static JButton LoadCity;
    static JButton LoadJob;
    static JButton AddJob;
    static JButton AddCity;
    static JButton ShowAllJobs;
    static JButton ShowAllCities;
    static JButton RemoveJob;
    static JButton RemoveCity;
    static JButton ShowBestJob;
    static JButton CalTotalSal;
    static DefaultTableModel tableModel1;
    static JTable table1;
    static DefaultTableModel CityDefaultTable;
    static DefaultTableModel JobOfferDefaultTable;


    @SuppressWarnings("methodlength")
    public static void main(String[] args) {


        //Create the frame for the GUI
        JFrame frame = new JFrame("YourJobComparator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);

        //Add Quit Button
        //Source of ActionListener code: https://www.youtube.com/watch?v=ZD6626aW54M&ab_channel=JalalAhmad
        Quit = new JButton();
        Quit.setBounds(50, 50, 100, 40);
        Quit.setText("Quit");
        frame.add(Quit);

        //EFFECTS: Quit the application
        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowEvent closeWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
            }
        });

        //Add LoadJob button
        LoadJob = new JButton();
        LoadJob.setBounds(50, 120, 100, 40);
        LoadJob.setText("LoadJob");
        frame.add(LoadJob);

        //EFFECTS: Load the JobOfferList
        LoadJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadJobOfferList();
            }
        });


        //Add SaveJob button
        SaveJob = new JButton();
        SaveJob.setBounds(50, 160, 100, 40);
        SaveJob.setText("SaveJob");
        frame.add(SaveJob);

        //EFFECTS: Save the JobOfferList
        SaveJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveJobOfferList();
            }
        });


        //Add AddJob button
        AddJob = new JButton();
        AddJob.setBounds(50, 200, 100, 40);
        AddJob.setText("AddJob");
        frame.add(AddJob);

        //EFFECTS: add the JobOffer to the JobOfferList
        AddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJobOffer();
            }
        });


        //Add RemoveJob button
        RemoveJob = new JButton();
        RemoveJob.setBounds(50, 240, 100, 40);
        RemoveJob.setText("RemoveJob");
        frame.add(RemoveJob);

        //EFFECTS: Remove JobOffer from the JobOfferList
        RemoveJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeJobOffer();
            }
        });


        //Add ShowAllJobs button
        ShowAllJobs = new JButton();
        ShowAllJobs.setBounds(50, 280, 100, 40);
        ShowAllJobs.setText("ShowAllJobs");
        frame.add(ShowAllJobs);

        //EFFECTS: Show the JobOfferList on the JPanel
        ShowAllJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJobOfferList();
            }
        });


        //Add the LoadCity button
        LoadCity = new JButton();
        LoadCity.setBounds(50, 350, 100, 40);
        LoadCity.setText("LoadCity");
        frame.add(LoadCity);

        //EFFECTS: Load the CityList
        LoadCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCityList();
            }
        });

        //Add SaveCity button
        SaveCity = new JButton();
        SaveCity.setBounds(50, 390, 100, 40);
        SaveCity.setText("SaveCity");
        frame.add(SaveCity);

        //EFFECTS: Save the City to the CityList
        SaveCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCityList();
            }
        });

        //Add AddCity button
        AddCity = new JButton();
        AddCity.setBounds(50, 430, 100, 40);
        AddCity.setText("AddCity");
        frame.add(AddCity);

        //EFFECTS: Add City to CityList
        AddCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCityInfo();
            }
        });


        //Add RemoveCity button
        RemoveCity = new JButton();
        RemoveCity.setBounds(50, 470, 100, 40);
        RemoveCity.setText("RemoveCity");
        frame.add(RemoveCity);

        //EFFECTS: Remove the city from the CityList
        RemoveCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCityInfo();
            }
        });


        //Add ShowAllCities button
        ShowAllCities = new JButton();
        ShowAllCities.setBounds(50, 510, 100, 40);
        ShowAllCities.setText("ShowAllCities");
        frame.add(ShowAllCities);

        //EFFECTS: Show the CityList on the JPanel
        ShowAllCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCityList();
            }
        });

        //Add the ShowBestJob button
        ShowBestJob = new JButton();
        ShowBestJob.setBounds(200, 200, 150, 40);
        ShowBestJob.setText("ShowBestJobOffer");
        frame.add(ShowBestJob);

        //EFFECTS: Find the Best JobOffer in the JobOfferList
        ShowBestJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBestJobOffer();
            }
        });


        //Add CalTotalSal button
        CalTotalSal = new JButton();
        CalTotalSal.setBounds(200, 280, 250, 40);
        CalTotalSal.setText("JobOfferTotalSalaryCalculation");
        frame.add(CalTotalSal);

        //EFFECTS: Calculate the total salary of the JobOffer
        CalTotalSal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calTotalSalaryConsole();
            }
        });


        //Add Table for the JobOfferList
        JobOfferDefaultTable = new DefaultTableModel(new Object[]{"Company", "Job Position",
                "Job Location", "Annual Salary", "Signing Bonus", "Stock Amount", "Stock Price"},
                        0);
        JTable jobOfferTable = new JTable(JobOfferDefaultTable);
        JScrollPane jobScrollPane = new JScrollPane(jobOfferTable);
        jobScrollPane.setBounds(500, 50, 800, 400);
        frame.add(jobScrollPane);


        //Add Table for the CityList
        CityDefaultTable = new DefaultTableModel(new Object[]{"City", "Country",
                "Living Expenses Per Month"}, 0);
        JTable cityTable = new JTable(CityDefaultTable);
        JScrollPane cityScrollPane = new JScrollPane(cityTable);
        cityScrollPane.setBounds(500, 450, 800, 400);
        frame.add(cityScrollPane);

        //Source: https://stackoverflow.com/questions/1466240/how-to-set-an-image-as-a-background-for-frame-in-swing-gui-of-java/1466278#1466278
        //EFFECTS: Set FAANG as the background image
        ImageIcon background = new ImageIcon("/Applications/project_b1w6b/data/960x0.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,100,500,1000);
        frame.add(back);

        //EFFECTS: Set Gregor as the background image
        ImageIcon background1 = new ImageIcon("/Applications/"
                + "project_b1w6b/data/800px-Gregor_Kiczales_AOSD.jpg");
        Image img1 = background1.getImage();
        Image temp1 = img1.getScaledInstance(300,200,Image.SCALE_SMOOTH);
        background1 = new ImageIcon(temp1);
        JLabel back1 = new JLabel(background1);
        back1.setLayout(null);
        back1.setBounds(0,-10,300,200);
        frame.add(back1);

        //EFFECTS: Set the background color as black
        frame.getContentPane().setBackground(Color.BLACK);

        try {
            new JobOfferComparatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }


}