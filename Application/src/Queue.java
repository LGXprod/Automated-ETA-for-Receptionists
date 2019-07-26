import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queue {

    public Queue(){

        String fileName = "new.csv";
        File file = new File(fileName);

        try {

            Scanner inputStream = new Scanner(file);

            while  (inputStream.hasNextLine()){

                String data = inputStream.nextLine();
                String[] patientQueue = data.split(",");
                Patient patient = new Patient(patientQueue[0], patientQueue[1], patientQueue[3],
                        Double.parseDouble(patientQueue[4]));


            }

            inputStream.close();

        } catch (FileNotFoundException e){

            e.printStackTrace();

        }

    }

}
