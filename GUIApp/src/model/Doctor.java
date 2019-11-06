package model;

import java.util.Scanner;

public class Doctor {

    private String id;
    private String fName;
    private int startHour;
    private int startMin;
    private String sName;
    private int avgWaitTime;

    public Doctor(String doctorID){

        id = doctorID;

        if (id.equals("6")){
            fName = "Any Doctor";
        } else if (id.equals("2")){
            fName = "Doctor B";
        } else if (id.equals("3")){
            fName = "Doctor C";
        } else if (id.equals("4")){
            fName = "Doctor D";
        } else if (id.equals("5")){
            fName = "Doctor B";
        } else if (id.equals("1")){
            fName = "Doctor A";
        } else if (id.equals("7")){
            fName = "Any female doctor";
        } else{
            fName = "Any male doctor";
        }

    }

    public String getfName(){
        return this.fName;
    }

    public String getId(){ return this.id; }

}
