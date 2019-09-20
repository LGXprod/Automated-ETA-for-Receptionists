import java.util.ArrayList;
import java.util.Arrays;

public class PatientLL {

    Patient head;
    Doctor doctorSpecified;

    public PatientLL(Doctor doctor){
        doctorSpecified = doctor;
    }

    public Doctor getDoctorSpecified(){
        return doctorSpecified;
    }

    public void insert(Patient newPatient){

        Patient patient = newPatient;

        if (head == null){

            head = patient;

        } else{

            Patient n = head;

            while (n.next != null){

                n = n.next;

            }

            n.next = patient;

        }

    }

    public int size(){
        if (head == null){
            return 0;
        } else{
            Patient patient = head;
            int count = 0;
            while (patient.next != null){
                ++count;
                patient = patient.next;
            }
            ++count;
            return count;
        }
    }

    public void printAll(){

        Patient patient = head;

        if (patient != null){
            while (patient.next != null){

                System.out.println(patient.toString());
                patient = patient.next;

            }

            System.out.println(patient.toString());
        }

    }

    public int calculateTotalWait(){

        Patient patient = head;
        int time = 0;

        while (patient.next != null){

            time += 15;
            patient = patient.next;

        }

        time += 15;

        return time;

    }

    public Patient findPatient(String id){

        Patient patient = head;

        while (patient.next != null && !patient.getGuid().equals(id)){

            patient = patient.next;

        }

        if (patient.getGuid().equals(id)){

            return patient;

        } else{

            return null;

        }


    }

//    public int patientWait(Patient patientWaiting, String id){
//
//        Patient patient = head;
//        Doctor docSpecified = patientWaiting.getDocSpecified();
//        int time = 0;
//
//        while (patient.next != null && !id.equals(patient.getGuid())){
//
//            if (docSpecified == patient.getDocSpecified()){
//                time = time + 15;
//            }
//            patient = patient.next;
//
//        }
//
//        return time;
//
//    }


    public int patientWait(Patient patientWaiting, String id, ArrayList<Doctor> doctors){ // Going to have to rewrite this so it splits doctors into individual tables then calculates times

        Patient patient = head;
        Doctor docSpecified = patientWaiting.getDocSpecified();
        int time = 0;

        while (patient.next != null && !id.equals(patient.getGuid())){

            if (docSpecified == patient.getDocSpecified()){
                time = time + 15;
            }
            patient = patient.next;

        }

        return time;

    }

//    public Patient deletePatient(String id){
//
//        Patient patientToDelete = findPatient(id);
//        Patient patient = head;
//
//
//
//    }

}
