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

    public int[] calculateTotalWait(){

        Patient patient = head;
        int[] times = new int[]{0,0,0,0,0,0};

        while (patient.next != null){

            if (patient.getDocSpecified().getId().equals("1")){
                times[0] = times[0] + 15;
            } else if (patient.getDocSpecified().getId().equals("2")){
                times[1] = times[1] + 15;
            } else if (patient.getDocSpecified().getId().equals("3")){
                times[2] = times[2] + 15;
            } else if (patient.getDocSpecified().getId().equals("4")){
                times[3] = times[3] + 15;
            } else if (patient.getDocSpecified().getId().equals("5")){
                times[4] = times[4] + 15;
            } else if (patient.getDocSpecified().getId().equals("6")){
                times[5] = times[5] + 15;
            }

            patient = patient.next;

        }

        if (patient.getDocSpecified().getId().equals("1")){
            times[0] = times[0] + 15;
        } else if (patient.getDocSpecified().getId().equals("2")){
            times[1] = times[1] + 15;
        } else if (patient.getDocSpecified().getId().equals("3")){
            times[2] = times[2] + 15;
        } else if (patient.getDocSpecified().getId().equals("4")){
            times[3] = times[3] + 15;
        } else if (patient.getDocSpecified().getId().equals("5")){
            times[4] = times[4] + 15;
        } else if (patient.getDocSpecified().getId().equals("6")){
            times[5] = times[5] + 15;
        }

        //System.out.println(Arrays.toString(times));

        return times;

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

    public int patientWait(Patient patientWaiting, String id){

        Patient patient = head;
        Doctor docSpecified = patientWaiting.getDocSpecified();
        int time = 0;

        while (patient.next != null && !id.equals(patient.getGuid())){

            if (docSpecified.getId().equals(patient.getDocSpecified().getId())){
                time = time + 15;
            }
            patient = patient.next;

        }

        return time;

    }

}
