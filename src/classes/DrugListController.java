package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DrugListController{
    public static Drug drug;
    public static int index;

    public List<String> fillDrug(){
        List <String> listi = new ArrayList<>();
        for(Drug d : ListOFDrug.listOfDrug)
            listi.add(d.getName());
        return listi;

    }

    @FXML
    private ChoiceBox drugListBox;

    @FXML
    private void homeClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (drugListBox.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void initialize(){
        drugListBox.setItems(FXCollections.observableArrayList(fillDrug()));
    }

    @FXML
    private void editClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/editDrug.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (drugListBox.getScene().getWindow());
            stage.setScene(scene);
            for(int i = 0 ; i < ListOFDrug.listOfDrug.size() ; i++){
                if(drugListBox.getSelectionModel().getSelectedItem().equals(ListOFDrug.listOfDrug.get(i).getName())){
                    index = i;
                    System.out.println(index);
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
