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

        JFrame frame = new JFrame("YourJobComparator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);


        //Source of ActionListener code: https://www.youtube.com/watch?v=ZD6626aW54M&ab_channel=JalalAhmad
        Quit = new JButton();
        Quit.setBounds(50, 50, 100, 40);
        Quit.setText("Quit");
        frame.add(Quit);
        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowEvent closeWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
            }
        });

        LoadJob = new JButton();
        LoadJob.setBounds(50, 120, 100, 40);
        LoadJob.setText("LoadJob");
        frame.add(LoadJob);
        LoadJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadJobOfferList();
            }
        });


        SaveJob = new JButton();
        SaveJob.setBounds(50, 160, 100, 40);
        SaveJob.setText("SaveJob");
        frame.add(SaveJob);
        SaveJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveJobOfferList();
            }
        });


        AddJob = new JButton();
        AddJob.setBounds(50, 200, 100, 40);
        AddJob.setText("AddJob");
        frame.add(AddJob);
        AddJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJobOffer();
            }
        });


        RemoveJob = new JButton();
        RemoveJob.setBounds(50, 240, 100, 40);
        RemoveJob.setText("RemoveJob");
        frame.add(RemoveJob);
        RemoveJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeJobOffer();
            }
        });


        ShowAllJobs = new JButton();
        ShowAllJobs.setBounds(50, 280, 100, 40);
        ShowAllJobs.setText("ShowAllJobs");
        frame.add(ShowAllJobs);
        ShowAllJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showJobOfferList();
            }
        });


        LoadCity = new JButton();
        LoadCity.setBounds(50, 350, 100, 40);
        LoadCity.setText("LoadCity");
        frame.add(LoadCity);
        LoadCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCityList();
            }
        });

        SaveCity = new JButton();
        SaveCity.setBounds(50, 390, 100, 40);
        SaveCity.setText("SaveCity");
        frame.add(SaveCity);
        SaveCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCityList();
            }
        });

        AddCity = new JButton();
        AddCity.setBounds(50, 430, 100, 40);
        AddCity.setText("AddCity");
        frame.add(AddCity);
        AddCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCityInfo();
            }
        });


        RemoveCity = new JButton();
        RemoveCity.setBounds(50, 470, 100, 40);
        RemoveCity.setText("RemoveCity");
        frame.add(RemoveCity);
        RemoveCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCityInfo();
            }
        });

        ShowAllCities = new JButton();
        ShowAllCities.setBounds(50, 510, 100, 40);
        ShowAllCities.setText("ShowAllCities");
        frame.add(ShowAllCities);
        ShowAllCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCityList();
            }
        });

        ShowBestJob = new JButton();
        ShowBestJob.setBounds(200, 200, 150, 40);
        ShowBestJob.setText("ShowBestJobOffer");
        frame.add(ShowBestJob);
        ShowBestJob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBestJobOffer();
            }
        });

        CalTotalSal = new JButton();
        CalTotalSal.setBounds(200, 280, 250, 40);
        CalTotalSal.setText("JobOfferTotalSalaryCalculation");
        frame.add(CalTotalSal);
        CalTotalSal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calTotalSalaryConsole();
            }
        });


        JobOfferDefaultTable = new DefaultTableModel(new Object[]{"Company", "Job Position",
                "Job Location", "Annual Salary", "Signing Bonus", "Stock Amount", "Stock Price"},
                        0);
        JTable jobOfferTable = new JTable(JobOfferDefaultTable);
        JScrollPane jobScrollPane = new JScrollPane(jobOfferTable);
        jobScrollPane.setBounds(500, 50, 800, 400);
        frame.add(jobScrollPane);

        CityDefaultTable = new DefaultTableModel(new Object[]{"City", "Country",
                "Living Expenses Per Month"}, 0);


        JTable cityTable = new JTable(CityDefaultTable);
        JScrollPane cityScrollPane = new JScrollPane(cityTable);
        cityScrollPane.setBounds(500, 450, 800, 400);
        frame.add(cityScrollPane);

        //Source: https://stackoverflow.com/questions/1466240/how-to-set-an-image-as-a-background-for-frame-in-swing-gui-of-java/1466278#1466278
        ImageIcon background = new ImageIcon("/Applications/project_b1w6b/data/960x0.jpg");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,100,500,1000);
        frame.add(back);

        ImageIcon background1 = new ImageIcon("/Applications/"
                + "project_b1w6b/data/800px-Gregor_Kiczales_AOSD.jpg");
        Image img1 = background1.getImage();
        Image temp1 = img1.getScaledInstance(300,200,Image.SCALE_SMOOTH);
        background1 = new ImageIcon(temp1);
        JLabel back1 = new JLabel(background1);
        back1.setLayout(null);
        back1.setBounds(0,-10,300,200);
        frame.add(back1);

        frame.getContentPane().setBackground(Color.BLACK);

        try {
            new JobOfferComparatorApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }


}