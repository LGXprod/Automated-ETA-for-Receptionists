import java.util.Arrays;

public class PatientLL {

    Patient head;

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

    public void printAll(){

        Patient patient = head;

        while (patient.next != null){

            System.out.println(patient.getFName());
            patient = patient.next;

        }

        System.out.println(patient.getFName());


    }

    public int[] calculateWait(){

        Patient patient = head;
        int[] times = new int[]{0,0,0,0,0};

        while (patient.next != null){

            if (patient.getDocSpecified().equals("Doctor A")){
                times[0] = times[0] + 15;
            } else if (patient.getDocSpecified().equals("Doctor B")){
                times[1] = times[1] + 15;
            } else if (patient.getDocSpecified().equals("Doctor C")){
                times[2] = times[2] + 15;
            } else if (patient.getDocSpecified().equals("Doctor D")){
                times[3] = times[3] + 15;
            } else if (patient.getDocSpecified().equals("Doctor E")){
                times[4] = times[4] + 15;
            }

            patient = patient.next;

        }

        if (patient.getDocSpecified().equals("Doctor A")) {

            if (patient.getDocSpecified().equals("Doctor A")){
                times[0] = times[0] + 15;
            } else if (patient.getDocSpecified().equals("Doctor B")){
                times[1] = times[1] + 15;
            } else if (patient.getDocSpecified().equals("Doctor C")){
                times[2] = times[2] + 15;
            } else if (patient.getDocSpecified().equals("Doctor D")){
                times[3] = times[3] + 15;
            } else if (patient.getDocSpecified().equals("Doctor E")){
                times[4] = times[4] + 15;
            }

        }

        //System.out.println(Arrays.toString(times));

        return times;

    }

}
