package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    public void start(Stage window){
        try {
            ListOfPatient.makeObject();
            ListOFDrug.makeList();
            for(Patient p : ListOfPatient.listOfPatient)
                ListOfPatient.total = p.totalMoney;

            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene scene = new Scene(pane);
            window.setScene(scene);
            window.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        launch(args);
    }
}
