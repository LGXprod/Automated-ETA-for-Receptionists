import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Doctor> doctors = new ArrayList<>();

        for (int i = 1; i <= 8; ++i){
            Doctor theDr = new Doctor(Integer.toString(i));
            doctors.add(theDr);
        }

        PatientQueue patientList = new PatientQueue(doctors);
        patientList.loadQueue();

    }
}
