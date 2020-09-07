package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class UserPassController {

    public TextField userTextField;
    public TextField passTextField;
    public Label incLabel;


    public void click() {
        String secretaryId = "monshi";
        String secretaryPass = "monshi";

        String doctorId = "doctor";
        String doctorPass = "doctor";

        String userText = userTextField.getText();
        String passText = passTextField.getText();


        if (userText.equals(secretaryId) && passText.equals(secretaryPass)){
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("/fxml/spage.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) (userTextField.getScene().getWindow());
                stage.setScene(scene);
            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (userText.equals(doctorId) && passText.equals(doctorPass)){
            try {
                Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) (userTextField.getScene().getWindow());
                stage.setScene(scene);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


         else {
            incLabel.setVisible(true);
        }
    }
}
