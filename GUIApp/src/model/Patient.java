package model;

import javafx.beans.property.*;

public class Patient {

    Patient next;
    private String guid;
    private StringProperty fName;
    private String sName;
    private int hourArrived;
    private int minArrived;
    private int avgTimeWDoc;
    private ObjectProperty<Doctor> docSpecified;
    private boolean isNew;

    public Patient(String id, String patientFName, String patientSName, int hour, int min, boolean newPatient, Doctor doctor){

        this.next = null;
        guid = id;
        this.fName = new SimpleStringProperty();
        this.fName.set(patientFName);
        sName = patientSName;
        hourArrived = hour;
        minArrived = min;
        docSpecified = new SimpleObjectProperty<Doctor>();
        docSpecified.set(doctor);
        isNew = newPatient;

    }

    public String getFName(){
        return fName.getValue();
    }

    public ReadOnlyStringProperty fNameProperty(){ return this.fName; }

    public Doctor getDocSpecified(){ return docSpecified.getValue(); }

    public ReadOnlyObjectProperty<Doctor> docSpecifiedProperty(){ return this.docSpecified; }

    public String getGuid(){
        return this.guid;
    }

    public int getHourArrived() { return this.hourArrived; }

    public int getMinArrived() { return this.minArrived; }



}
