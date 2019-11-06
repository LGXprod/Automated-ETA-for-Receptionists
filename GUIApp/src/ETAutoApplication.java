import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import java.util.ArrayList;
import model.*;

public class ETAutoApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/patientTimes.fxml"));
        Parent root = loader.load();
        stage.setTitle("etAuto");
        stage.setScene(new Scene(root));
        //stage.setFullScreen(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

        ArrayList<Doctor> doctors = new ArrayList<>();

        for (int i = 1; i <= 8; ++i){
            Doctor theDr = new Doctor(Integer.toString(i));
            doctors.add(theDr);
        }

        PatientQueue patientList = new PatientQueue(doctors);
        patientList.loadQueue();
    }

}
