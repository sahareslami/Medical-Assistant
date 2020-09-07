package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FilterListController {
    ObservableList<TypeOfInsurance> toi = FXCollections.observableArrayList(TypeOfInsurance.TYPEA , TypeOfInsurance.TYPEB , TypeOfInsurance.TYPEC);

    private List<Integer> fillAge(){
        List<Integer> number = new ArrayList<>();
        for(int i = 1 ; i < 100 ; i++)
            number.add(i);
        return number;

    }

    private List<String> fillPatient(){
        List<String> listi = new ArrayList<>();
        for(Patient p : ListOfPatient.listOfPatient)
            listi.add(p.getId());
        return listi;
    }



    @FXML
    private ChoiceBox patientCastBox;

    @FXML
    private ChoiceBox resultDateBox;

    @FXML
    private ChoiceBox typeOfInsuranceBox;

    @FXML
    private Label totalCastBox;

    @FXML
    private ChoiceBox resultAgeBox;

    @FXML
    private DatePicker dateBox;

    @FXML
    private ChoiceBox resultTypeOfInsuranceBox;

    @FXML
    private ChoiceBox ageBox;

    @FXML
    private Label totalLabel;

    @FXML
    private void initialize(){
        typeOfInsuranceBox.setItems(toi);

        ageBox.setItems(FXCollections.observableArrayList(fillAge()));

        patientCastBox.setItems(FXCollections.observableArrayList(fillPatient()));

        totalLabel.setText(ListOfPatient.total + "");


    }
    @FXML
    private void typeOfInsuranceClicked() {

        if (((TypeOfInsurance) (typeOfInsuranceBox.getSelectionModel().getSelectedItem())).ordinal() == TypeOfInsurance.TYPEA.ordinal()) {
            List<Patient> listi = new ArrayList<>();
            for (Patient p : ListOfPatient.listOfPatient) {
                if (p.getInsurance().getType().ordinal() == TypeOfInsurance.TYPEA.ordinal())
                    listi.add(p);
            }
            ObservableList<Patient> pList = FXCollections.observableArrayList(listi);
            resultTypeOfInsuranceBox.setItems(pList);
        }


        if (((TypeOfInsurance) (typeOfInsuranceBox.getSelectionModel().getSelectedItem())).ordinal() == TypeOfInsurance.TYPEB.ordinal()) {
            List<Patient> listi = new ArrayList<>();
            for (Patient p : ListOfPatient.listOfPatient) {
                if (p.getInsurance().getType().ordinal() == TypeOfInsurance.TYPEB.ordinal())
                    listi.add(p);
            }
            ObservableList<Patient> pList = FXCollections.observableArrayList(listi);
            resultTypeOfInsuranceBox.setItems(pList);
        }

        if (((TypeOfInsurance) (typeOfInsuranceBox.getSelectionModel().getSelectedItem())).ordinal() == TypeOfInsurance.TYPEC.ordinal()) {
            List<Patient> listi = new ArrayList<>();
            {
                System.out.print("SWEDNJNFJKNRTJGNJNJNTJNTJNG");
            }
            for (Patient p : ListOfPatient.listOfPatient) {
                if (p.getInsurance().getType().ordinal() == TypeOfInsurance.TYPEC.ordinal())
                    listi.add(p);
            }
            ObservableList<Patient> pList = FXCollections.observableArrayList(listi);
            resultTypeOfInsuranceBox.setItems(pList);
        }
    }

    @FXML
    private void ageClicked(){
        List<Patient> listi = new ArrayList<>();
        int old = ageBox.getSelectionModel().getSelectedIndex() + 1;
        for(Patient p : ListOfPatient.listOfPatient){
            if(p.getAge() == old)
                listi.add(p);
        resultAgeBox.setItems(FXCollections.observableArrayList(listi));

        }
    }

    @FXML
    private void castClicked(){

        for(Patient p : ListOfPatient.listOfPatient) {
           if(p.getId().equals(patientCastBox.getSelectionModel().getSelectedItem()))
               totalCastBox.setText(p.totalMoney + "");

        }
    }

    @FXML
    private void homeClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (patientCastBox.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void dateClicked() {
        List<Patient> listi = new ArrayList<>();
        for (Patient p : ListOfPatient.listOfPatient) {
            if (p.getDob().getYear() == dateBox.getValue().getYear() &&
                    p.getDob().getDay() == dateBox.getValue().getDayOfMonth()) {
                listi.add(p);
            }
            resultDateBox.setItems(FXCollections.observableArrayList(listi));
        }
    }


}
