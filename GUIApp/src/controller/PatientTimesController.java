package controller;

import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import model.Doctor;
import model.Patient;
import model.PatientTimes;

import java.util.ArrayList;
import java.util.List;


public class PatientTimesController {

    @FXML private TableView<Patient> patientsTv;
    @FXML private TableColumn<Patient, String> fNameClm;
    @FXML private TableColumn<Patient, String> sNameClm;
    @FXML private TableColumn<Patient, String> etaClm;
    private PatientTimes patientTimes;

    public List<Patient> getSelectedPatients(){
        return patientsTv.getSelectionModel().getSelectedItems();
    }

    @FXML private void initialize(){
        System.out.println("Here");

        ArrayList<Doctor> doctors = new ArrayList<>();

        for (int i = 1; i <= 8; ++i){
            Doctor theDr = new Doctor(Integer.toString(i));
            doctors.add(theDr);
        }

        patientTimes = new PatientTimes(doctors);

        patientsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        patientsTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        fNameClm.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
        sNameClm.setCellValueFactory(cellData -> cellData.getValue().sNameProperty());

    }

    public PatientTimes getPatientTimes(){
        return patientTimes;
    }

    public void handleSelectedRows(MouseEvent event){
        System.out.println("Clicked");
    }

}
