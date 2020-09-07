package classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddDrugController {

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
    void saveClicked() {
        String name = "";
        String timeTable = "";
        String dosage = "";
        String discription = "";
        boolean empty = false;

        if (nameTextField.getText().isEmpty())
            empty = true;
        else
            name = nameTextField.getText();

        if (dosageTextField.getText().isEmpty())
            empty = true;
        else
            dosage = (dosageTextField.getText());

        if (timetableTextField.getText().isEmpty())
            empty = true;
        else
            timeTable = timetableTextField.getText();

        if (discriptionTextField.getText().isEmpty())
            empty = true;
        else
            discription = discriptionTextField.getText();

        if (empty) {
            messageLabel.setVisible(true);
        } else {
            messageLabel.setVisible(false);
            Drug d = new Drug(name, dosage, timeTable, discription);
            d.saveInfo();
            ListOFDrug.add(d);

        }

    }

    @FXML
    private void homeClicked() {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (dosageTextField.getScene().getWindow());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}