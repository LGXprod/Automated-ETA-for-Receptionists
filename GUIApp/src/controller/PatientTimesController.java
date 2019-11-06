package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Patient;


public class PatientTimesController {

    @FXML private TableView<Patient> patientsTv;
    @FXML private TableColumn<Patient, String> nameClm;
    @FXML private TableColumn<Patient, String> doctorClm;
    @FXML private TableColumn<Patient, String> etaClm;

    @FXML private void initialize(){
        System.out.println("Here");

    }

}
