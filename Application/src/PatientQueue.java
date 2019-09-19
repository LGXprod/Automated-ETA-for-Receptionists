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
                        PatientLL min = patientLLs[0];
                        for (PatientLL patientLLCheck : patientLLs){
                            if (patientLLCheck.size() <= min.size()){
                                min = patientLLCheck;
                            }
                        }
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
                        doctorSpecified = availableDoctors.get(6); // doctor A
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
            System.out.println(patientLL.getDoctorSpecified().getfName());
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


    }

    /*
    public void showList(PatientLL patientLL){
        int[] docETAs = patientLL.calculateTotalWait(availableDoctors);
        //System.out.println(Arrays.toString(docETAs));
        System.out.println("Doctor A: " + ((double)docETAs[0]/60) + " hour wait"); // problem could be that the ETA is correct for b but its supposed to be for a
        System.out.println("Doctor B: " + ((double)docETAs[1]/60) + " hour wait");
        System.out.println("Doctor C: " + ((double)docETAs[2]/60) + " hour wait");
        System.out.println("Doctor D: " + ((double)docETAs[3]/60) + " hour wait");
        System.out.println("Doctor E: " + ((double)docETAs[4]/60) + " hour wait");
        System.out.println("Any doctor: " + ((double)docETAs[5]/60) + " hour wait");

        //String id = "c1a886e8-fc48-5b10-98cf-eb21b8d20220";

        Scanner sc = new Scanner(System.in);
        System.out.print("Input user ID: ");
        String id = sc.nextLine();
        Patient foundPatient = patientLL.findPatient(id);
        double waitTime = ((double)patientLL.patientWait(foundPatient, id, availableDoctors))/60;
        int waitHour = (int)waitTime;
        double waitMin = (waitTime-waitHour)*60;

        System.out.println("ETA for " + foundPatient.getFName() + " to see "
                + foundPatient.getDocSpecified().getfName() + " is " + waitHour + " hours and " +
                waitMin + " minutes.");
    }*/



}
