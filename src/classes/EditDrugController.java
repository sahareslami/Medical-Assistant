package classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditDrugController {

    @FXML
    private TextArea discriptionTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField dosageTextField;

    @FXML
    private TextField timetableTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private void initialize(){
        System.out.println(ListOFDrug.listOfDrug.get(DrugListController.index));
        discriptionTextField.setText(ListOFDrug.listOfDrug.get(DrugListController.index).getDescription());
        nameTextField.setText(ListOFDrug.listOfDrug.get(DrugListController.index).getName());
        dosageTextField.setText(ListOFDrug.listOfDrug.get(DrugListController.index).getDosage());
        timetableTextField.setText(ListOFDrug.listOfDrug.get(DrugListController.index).getTableTime());
    }

    @FXML
    void saveClicked(){

        boolean isEmpty = false;
        if(discriptionTextField.getText().isEmpty())
            isEmpty = true;
        else
            ListOFDrug.listOfDrug.get(DrugListController.index).setDescription(discriptionTextField.getText());

        if(dosageTextField.getText().isEmpty())
            isEmpty = true;
        else
            ListOFDrug.listOfDrug.get(DrugListController.index).setDosage(dosageTextField.getText());

        if(timetableTextField.getText().isEmpty())
            isEmpty = true;
        else
            ListOFDrug.listOfDrug.get(DrugListController.index).setTableTime(timetableTextField.getText());

        if(nameTextField.getText().isEmpty())
            isEmpty = true;
        else
            ListOFDrug.listOfDrug.get(DrugListController.index).setName(nameTextField.getText());

        if(isEmpty)
            messageLabel.setVisible(true);

    }

    @FXML
    void homeClicked() {        try {
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) (discriptionTextField.getScene().getWindow());
        stage.setScene(scene);
    }catch (Exception e){
        e.printStackTrace();
    }

    }


}
