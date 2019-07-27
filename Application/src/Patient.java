public class Patient {

    Patient next;
    private String guid;
    private String fName;
    private String sName;
    private int hourArrived;
    private int minArrived;
    private int avgTimeWDoc;

    public Patient(String id, String patientFName, String patientSName, int hour, int min){

        this.next = null;
        guid = id;
        fName = patientFName;
        sName = patientSName;
        hourArrived = hour;
        minArrived = min;


    }

    public String getFName(){
        return this.fName;
    }


}
