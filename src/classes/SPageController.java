package classes;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class SPageController {
    @FXML
    private Label ding;


    @FXML
    void addClicked() {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/registPatients.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (ding.getScene().getWindow());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    void searchClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/searchPatient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (ding.getScene().getWindow());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
