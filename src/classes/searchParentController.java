package classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class searchParentController {

    public static Patient founded;
    public static int indx;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label notFoundLabel;
    @FXML
    public void search() {
        boolean f = false;
        String foundId = searchTextField.getText();
        System.out.println(foundId);
        for (Patient p : ListOfPatient.listOfPatient){
            if (p.getId().equals(foundId)){
                f = true;
                founded = p;
                indx = ListOfPatient.listOfPatient.indexOf(p);
                try {
                    Pane pane = FXMLLoader.load(getClass().getResource("/fxml/editInfo.fxml"));
                    Scene scene = new Scene(pane);
                    Stage stage = (Stage) (searchTextField.getScene().getWindow());
                    stage.setScene(scene);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(!f){
            notFoundLabel.setVisible(true);
        }

    }
    @FXML
    public void visitClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/selectVisit.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (searchTextField.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
