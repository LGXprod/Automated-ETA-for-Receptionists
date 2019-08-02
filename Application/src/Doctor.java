public class Doctor {

    private String id;
    private String fName;
    private String sName;
    private int avgWaitTime;

    public Doctor(String doctorID){

        id = doctorID;

        if (id == "6"){
            fName = "Any Doctor";
        } else if (id == "2"){
            fName = "Doctor B";
        } else if (id == "3"){
            fName = "Doctor C";
        } else if (id == "4"){
            fName = "Doctor D";
        } else if (id == "5"){
            fName = "Doctor B";
        } else if (id == "1"){
            fName = "Doctor A";
        } else if (id == "7"){
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
