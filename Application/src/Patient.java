public class Patient {

    Patient next;
    private String guid;
    private String fName;
    private String sName;
    private int hourArrived;
    private int minArrived;
    private int avgTimeWDoc;
    private String docSpecified;

    public Patient(String id, String patientFName, String patientSName, int hour, int min, String doctor){

        this.next = null;
        guid = id;
        fName = patientFName;
        sName = patientSName;
        hourArrived = hour;
        minArrived = min;
        docSpecified = doctor;


    }

    public String getFName(){
        return this.fName;
    }

    public String getDocSpecified(){

        return this.docSpecified;

    }



}
