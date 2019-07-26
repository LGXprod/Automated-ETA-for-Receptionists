public class Patient {

    String guid;
    String fName;
    String sName;
    double avgTimeWDoc;

    public Patient(String id, String patientFName, String patientSName, double patientTime){

        guid = id;
        fName = patientFName;
        sName = patientSName;
        avgTimeWDoc = patientTime;

    }


}
