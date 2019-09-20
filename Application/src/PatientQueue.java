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

public class PatientQueue {

    private ArrayList<Doctor> availableDoctors;
    private PatientLL[] patientLLs;


    public PatientQueue(ArrayList<Doctor> availableDoctors){

        this.availableDoctors = availableDoctors;

    }

    public void loadQueue(){

        String fileName = "patientListMorning.csv";
        File file = new File(fileName);

        patientLLs = new PatientLL[8];

        int count = 0;
        for (Doctor doctor : availableDoctors){
            patientLLs[count] = new PatientLL(doctor);
            ++count;
        }

        initialCSV(file);
        showLists();
        calculateTotalWait();

    }

    public void calculateTotalWait(){
        int totalWait = 0;
        for (PatientLL patientLL : patientLLs){
            if (patientLL.getDoctorSpecified() != availableDoctors.get(5)) {
                System.out.println(patientLL.getDoctorSpecified().getfName() + "'s wait time = " + (double)patientLL.calculateTotalWait()/60.0 + " hours.");
                totalWait += patientLL.calculateTotalWait();
            }
        }
        System.out.println("The wait for any doctor is " + (double)minWait().calculateTotalWait()/60.0 + " hours.");
        System.out.println("Total wait = " + (double)totalWait/60.0 + " hours.");
    }

    public PatientLL minWait(){
        PatientLL min = patientLLs[0];
        for (PatientLL patientLLCheck : patientLLs){
            if (patientLLCheck.size() <= min.size()){
                min = patientLLCheck;
            }
        }
        return min;
    }

    public void initialCSV(File file){

        Doctor doctorSpecified;

        try {

            Scanner inputStream = new Scanner(file);
            Patient patient;

            while  (inputStream.hasNextLine()){

                String data = inputStream.nextLine();
                String[] patientQueue = data.split(",");
                if (patientQueue[0].equals("guid")){
                    continue;
                }

                //System.out.println(patientQueue[7]);
                switch (patientQueue[7]){
                    case "6":
                        PatientLL min = minWait();
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), availableDoctors.get(5));
                        min.insert(patient);
                        break;
                    case "2":
                        doctorSpecified = availableDoctors.get(1); // doctor b
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[1].insert(patient);
                        break;
                    case "3":
                        doctorSpecified = availableDoctors.get(2); // doctor c
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[2].insert(patient);
                        break;
                    case "4":
                        doctorSpecified = availableDoctors.get(3); // doctor d
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[3].insert(patient);
                        break;
                    case "5":
                        doctorSpecified = availableDoctors.get(4); // doctor e
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[4].insert(patient);
                        break;
                    case "1":
                        doctorSpecified = availableDoctors.get(0); // doctor A
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[0].insert(patient);
                        break;
                    case "7":
                        doctorSpecified = availableDoctors.get(7); // any female doctor
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[6].insert(patient);
                    case "8":
                        doctorSpecified = availableDoctors.get(8); // any female doctor
                        patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[2],
                                Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                        patientLLs[7].insert(patient);
                }

            }

            inputStream.close();

        } catch (FileNotFoundException e){

            e.printStackTrace();

        }



    }

    public void showLists(){

        for (PatientLL patientLL : patientLLs){
            System.out.println(patientLL.getDoctorSpecified().getfName() + ":");
            patientLL.printAll();
            System.out.println();
        }

    }

    /*
    public void updateCSV(File file, PatientLL patientLL){

        long lastChanged = file.lastModified();
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(sdf.format(lastChanged));

        try {
            while (true){
                Thread.sleep(2000);
                initialCSV(file, patientLL);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }*/



}
