package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.File;

public class SelectVisitController{


    @FXML
    private ChoiceBox visitBox;

    @FXML
    private void initialize(){
        System.out.println(searchParentController.indx);
       visitBox.setItems(FXCollections.observableArrayList(ListOfPatient.listOfPatient.get(searchParentController.indx).getDateOfVisit()));
    }

    @FXML
    void selectDate(){


    }

}
