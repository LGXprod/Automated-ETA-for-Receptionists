import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PatientQueue {

    private ArrayList<Doctor> availableDoctors;

    public PatientQueue(ArrayList<Doctor> availableDoctors){

        this.availableDoctors = availableDoctors;

    }

    public void loadQueue(){

        String fileName = "patientListMorning.csv";
        File file = new File(fileName);

        PatientLL patientLL = new PatientLL(); // Look at this line
        Doctor doctorSpecified;

        try {

            Scanner inputStream = new Scanner(file);

            while  (inputStream.hasNextLine()){

                String data = inputStream.nextLine();
                String[] patientQueue = data.split(",");
                if (patientQueue[0].equals("guid")){
                    continue;
                }
                // Doctor doctorSpecified = new Doctor(patientQueue[7]); // This line creates a unique doctor object for every patient despite the intention being to check which docs were in

                if (patientQueue[7].equals("6")){
                    doctorSpecified = availableDoctors.get(6);
                } else if (patientQueue[7].equals("2")){
                    doctorSpecified = availableDoctors.get(2);
                } else if (patientQueue[7].equals("3")){
                    doctorSpecified = availableDoctors.get(3);
                } else if (patientQueue[7].equals("4")){
                    doctorSpecified = availableDoctors.get(4);
                } else if (patientQueue[7].equals("5")){
                    doctorSpecified = availableDoctors.get(5);
                } else if (patientQueue[7].equals("1")){
                    doctorSpecified = availableDoctors.get(1);
                } else if (patientQueue[7].equals("7")){
                    doctorSpecified = availableDoctors.get(7);
                } else{
                    doctorSpecified = availableDoctors.get(8);
                }

                Patient patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[3],
                        Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), Boolean.parseBoolean(patientQueue[6]), doctorSpecified);
                patientLL.insert(patient);


            }

            inputStream.close();

        } catch (FileNotFoundException e){

            e.printStackTrace();

        }

        //patientLL.printAll();

        int[] docETAs = patientLL.calculateTotalWait(availableDoctors);
        System.out.println(Arrays.toString(docETAs));
        System.out.println("Doctor A: " + ((double)docETAs[0]/60) + " hour wait");
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
        double waitTime = ((double)patientLL.patientWait(foundPatient, id))/60;
        int waitHour = (int)waitTime;
        double waitMin = (waitTime-waitHour)*60;

        System.out.println("ETA for " + foundPatient.getFName() + " to see "
                + foundPatient.getDocSpecified().getfName() + " is " + waitHour + " hours and " +
                waitMin + " minutes.");
        //System.out.println(patientLL.patientWait(foundPatient, id));

        // Need to split csv into much smaller lists to test methods of estimating times
        // Then need to create a python script that appends new instances of the csv and make the java app accommodate this
    }

}
