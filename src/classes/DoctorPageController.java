package classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DoctorPageController{
    @FXML
    private Label titleLabel;

    @FXML
    private void searchClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/searchPatent.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (titleLabel.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    private void addClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/registPatients.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (titleLabel.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void medicinesClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/addDrug.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (titleLabel.getScene().getWindow());
            stage.setScene(scene);
         }catch (Exception e){
             e.printStackTrace();
         }
    }
    @FXML
    private void ListOfDrugClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/drugList.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (titleLabel.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void patientListClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/filterList.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (titleLabel.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
