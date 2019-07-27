import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        PatientQueue patientList = new PatientQueue();
        patientList.loadQueue();

    }
}
