package model;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PatientTimes {

    private ArrayList<Doctor> availableDoctors;
    private ObservableList<Patient> patients;
    private ObservableList<Patient> currentView;

    public PatientTimes(ArrayList<Doctor> availableDoctors){

        this.availableDoctors = availableDoctors;

        patients = FXCollections.<Patient>observableArrayList();
        currentView = FXCollections.<Patient>observableArrayList();

        String fileName = "patientListMorning.csv";
        File file = new File(fileName);


        try {

            Doctor doctorSpecified;
            Scanner inputStream = new Scanner(file);

            while  (inputStream.hasNextLine()){

                String data = inputStream.nextLine();
                String[] patientQueue = data.split(",");
                if (patientQueue[0].equals("guid")){
                    continue;
                }
                // Doctor doctorSpecified = new Doctor(patientQueue[7]); // This line creates a unique doctor object for every patient despite the intention being to check which docs were in

                if (patientQueue[7].equals("6")){
                    doctorSpecified = availableDoctors.get(5);
                } else if (patientQueue[7].equals("2")){
                    doctorSpecified = availableDoctors.get(1);
                } else if (patientQueue[7].equals("3")){
                    doctorSpecified = availableDoctors.get(2);
                } else if (patientQueue[7].equals("4")){
                    doctorSpecified = availableDoctors.get(3);
                } else if (patientQueue[7].equals("5")){
                    doctorSpecified = availableDoctors.get(4);
                } else if (patientQueue[7].equals("1")){
                    doctorSpecified = availableDoctors.get(0);
                } else if (patientQueue[7].equals("7")){
                    doctorSpecified = availableDoctors.get(6);
                } else{
                    doctorSpecified = availableDoctors.get(7);
                }

                Patient patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                        Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                patients.add(patient);

            }

            inputStream.close();

        } catch (FileNotFoundException e){

            e.printStackTrace();

        }

        currentView.addAll(patients);

        patients.addListener(new ListChangeListener<Patient>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Patient> c) {
                currentView.clear();
                currentView.addAll(patients);
            }

        });

    }

    public ObservableList<Patient> getCurrentView(){
        return currentView;
    }

}
