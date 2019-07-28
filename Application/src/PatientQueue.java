import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PatientQueue {

    //private Patient[] work = new Patient[250];

    public PatientQueue(){

        //System.out.println("hello");

    }

    public void loadQueue(){

        String fileName = "new.csv";
        File file = new File(fileName);

        PatientLL patientLL = new PatientLL();

        try {

            Scanner inputStream = new Scanner(file);

            while  (inputStream.hasNextLine()){

                String data = inputStream.nextLine();
                String[] patientQueue = data.split(",");
                if (patientQueue[0].equals("guid")){
                    continue;
                }
                Patient patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[3],
                        Integer.parseInt(patientQueue[4]), Integer.parseInt(patientQueue[5]), patientQueue[6]);
                patientLL.insert(patient);


            }

            inputStream.close();

        } catch (FileNotFoundException e){

            e.printStackTrace();

        }

        //patientLL.printAll();

        int[] docETAs = patientLL.calculateWait();
        System.out.println(Arrays.toString(docETAs));
        System.out.println("Doctor A: " + ((double)docETAs[0]/60) + " hour wait");
        System.out.println("Doctor B: " + ((double)docETAs[1]/60) + " hour wait");
        System.out.println("Doctor C: " + ((double)docETAs[2]/60) + " hour wait");
        System.out.println("Doctor D: " + ((double)docETAs[3]/60) + " hour wait");
        System.out.println("Doctor E: " + ((double)docETAs[4]/60) + " hour wait");

    }

}
