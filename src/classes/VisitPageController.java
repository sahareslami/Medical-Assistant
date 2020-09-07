package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.time.LocalDate;

public class VisitPageController {

    ObservableList<Drug> listOfDrug = FXCollections.observableArrayList(ListOFDrug.listOfDrug);

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox drugBox7;

    @FXML
    private TextArea diagnosisTextField;

    @FXML
    private ChoiceBox drugBox8;

    @FXML
    private ChoiceBox drugBox5;

    @FXML
    private ChoiceBox drugBox6;

    @FXML
    private ChoiceBox drugBox3;

    @FXML
    private ChoiceBox drugBox4;

    @FXML
    private ChoiceBox drugBox1;

    @FXML
    private ChoiceBox drugBox2;

    @FXML
    private TextArea descriptionTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField castTextField;


    @FXML
    private void initialize(){
        drugBox1.setItems(listOfDrug);
        drugBox2.setItems(listOfDrug);
        drugBox3.setItems(listOfDrug);
        drugBox4.setItems(listOfDrug);
        drugBox5.setItems(listOfDrug);
        drugBox6.setItems(listOfDrug);
        drugBox7.setItems(listOfDrug);
        drugBox8.setItems(listOfDrug);
    }



    @FXML
    void homeClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (drugBox1.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void saveClicked(){
        boolean isEmpty = false;
        String description = "";
        if(descriptionTextField.getText().isEmpty())
            isEmpty = true;
        else
            description = descriptionTextField.getText();

        String diagnosis = "";
        if(diagnosisTextField.getText().isEmpty())
            isEmpty = true;
        else
            diagnosis = diagnosisTextField.getText();

        int cast = 0;

        if(castTextField.getText().isEmpty())
            isEmpty = true;

       else
            cast = Integer.parseInt(castTextField.getText());



        List<Drug> drugstro = new ArrayList<>();
        if(!drugBox1.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox1.getSelectionModel().getSelectedItem());

        if(!drugBox2.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox2.getSelectionModel().getSelectedItem());

        if(!drugBox3.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox3.getSelectionModel().getSelectedItem());

        if(!drugBox4.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox4.getSelectionModel().getSelectedItem());

        if(!drugBox5.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox5.getSelectionModel().getSelectedItem());

        if(!drugBox6.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox6.getSelectionModel().getSelectedItem());

        if(!drugBox7.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox7.getSelectionModel().getSelectedItem());

        if(!drugBox8.getSelectionModel().isEmpty())
            drugstro.add((Drug)drugBox8.getSelectionModel().getSelectedItem());


        if(isEmpty)
            messageLabel.setVisible(true);


        {
            messageLabel.setVisible(false);
            //System.out.println((ListOfPatient.listOfPatient.get(ListOfPatient.listOfPatient.size() - 1)));
            searchParentController.founded.visit(description, diagnosis, drugstro , Date.from((date.getValue()).atStartOfDay(ZoneId.systemDefault()).toInstant()) , cast);
            RegistPatientsController.patient.saveDrugs();
            RegistPatientsController.patient.saveDiagnosis();
            RegistPatientsController.patient.saveDescription();
            RegistPatientsController.patient.saveCast();
        }


    }

}
