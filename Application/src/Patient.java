public class Patient {

    Patient next;
    private String guid;
    private String fName;
    private String sName;
    private int hourArrived;
    private int minArrived;
    private int avgTimeWDoc;
    private Doctor docSpecified;
    private boolean isNew;

    public Patient(String id, String patientFName, String patientSName, int hour, int min, boolean newPatient, Doctor doctor){

        this.next = null;
        guid = id;
        fName = patientFName;
        sName = patientSName;
        hourArrived = hour;
        minArrived = min;
        docSpecified = doctor;
        isNew = newPatient;

    }

    public String getFName(){
        return this.fName;
    }

    public Doctor getDocSpecified(){ return this.docSpecified; }

    public String getGuid(){
        return this.guid;
    }



}
