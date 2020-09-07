package classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EditInfoController{

    private Patient edit = searchParentController.founded;

    ObservableList<Title> titleOfPatient = FXCollections.observableArrayList(Title.Mr , Title.Ms , Title.Mrs , Title.Miss);


    private List<Integer> fillYear(){
        List<Integer> year = new ArrayList<Integer>();
        for(int i = 2018 ; i > 1918 ; i--){
            year.add(new Integer(i));
        }
        return year;

    }
    private List<Integer> fillDay(){
        List<Integer> day = new ArrayList<Integer>();
        for(int i = 1 ; i <= 31 ; i++){
            day.add(new Integer(i));
        }
        return day;
    }




    ObservableList<Monthes> month = FXCollections.observableArrayList(Monthes.JANUARY , Monthes.FEBRUARY , Monthes. MARCH ,
            Monthes.APRIL , Monthes.MAY , Monthes.JUNN ,
            Monthes.JULY , Monthes.AUGUST, Monthes.SEPTEMBER ,
            Monthes.OCTOBER , Monthes.NOVEMBER , Monthes.DECEMBER);
    ObservableList<TypeOfInsurance> typeOfIn = FXCollections.observableArrayList(TypeOfInsurance.TYPEA , TypeOfInsurance.TYPEB , TypeOfInsurance.TYPEC);

    @FXML
    private ChoiceBox title;
    @FXML
    private ChoiceBox yearOfBirth;
    @FXML
    private ChoiceBox monthOfBirth;
    @FXML
    private ChoiceBox dayOfBirth;
    @FXML
    private ChoiceBox typeOfInsurance;
    @FXML
    private ChoiceBox yearOfEx;
    @FXML
    private ChoiceBox monthOfEx;



    @FXML
    private CheckBox maleBox;
    @FXML
    private CheckBox femaleBox;

    @FXML
    private void handleMaleBox(){
        if(maleBox.isSelected())
            femaleBox.setSelected(false);
    }
    @FXML
    private void handleFemaleBox(){
        if(femaleBox.isSelected())
            maleBox.setSelected(false);
    }
    //personal info
    @FXML
    private TextField identifyNoTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField fathersnameTextField;

    //address
    @FXML
    private TextField stateTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField addressTextField;

    //contact info
    @FXML
    private TextField telTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField faxTextField;

    //insurance
    @FXML
    private TextField insuranceIdTextField;
    @FXML
    private Label messeageLabel;

    @FXML
    private void homeClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (stateTextField.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        title.setItems(titleOfPatient);
        yearOfBirth.setItems(FXCollections.observableArrayList(fillYear()));
        monthOfBirth.setItems(month);
        dayOfBirth.setItems(FXCollections.observableArrayList(fillDay()));
        typeOfInsurance.setItems(typeOfIn);
        yearOfEx.setItems(FXCollections.observableArrayList(fillYear()));
        monthOfEx.setItems(month);
        System.out.println(edit);

        //set
        title.setValue(edit.getTitle());
        identifyNoTextField.setText(edit.getId());
        firstNameTextField.setText(edit.getFirstName());
        lastNameTextField.setText(edit.getLastName());
        fathersnameTextField.setText(edit.getFathersName());
        yearOfBirth.setValue(edit.getDob().getYear() + 1900);
        monthOfBirth.setValue(Monthes.values()[edit.getDob().getMonth()]);
        //dayOfBirth.setValue((Integer)(edit.getDob().getDay()));

        //address
        if(!edit.getAddress().getAddress().equals("null")) addressTextField.setText(edit.getAddress().getAddress());
        if(!edit.getAddress().getState().equals("null"))stateTextField.setText(edit.getAddress().getState());
        if(!edit.getAddress().getCity().equals("null")) cityTextField.setText(edit.getAddress().getCity());

        //contact
        if(!edit.getContact().getTel().equals("null")) telTextField.setText(edit.getContact().getTel());
        if(!edit.getContact().getFax().equals("null"))faxTextField.setText(edit.getContact().getFax());
        if(!edit.getContact().getMail().equals("null"))mailTextField.setText(edit.getContact().getMail());
        if(!edit.getContact().getPhone().equals("null")) phoneTextField.setText(edit.getContact().getPhone());

        //insurance
        if(!edit.getInsurance().getInsuranceId().equals("null")) {
            typeOfInsurance.setValue(edit.getInsurance().getType());
            insuranceIdTextField.setText(edit.getInsurance().getInsuranceId());
            yearOfEx.setValue(edit.getInsurance().getExpirationDate().getYear() + 1900);
            monthOfEx.setValue(Monthes.values()[edit.getInsurance().getExpirationDate().getMonth()]);
        }

    }

    @FXML
    public void save(){

        boolean notFilled = true;
        //personal info
        if(!title.getSelectionModel().isEmpty())
            edit.setTitle((Title)(title.getSelectionModel().getSelectedItem()));
        else {
            notFilled = false;
            edit.setTitle(Title.Mr);
        }

        if(identifyNoTextField.getText().isEmpty())
            notFilled = false;
        else{
            edit.setId(identifyNoTextField.getText());
        }



        if(firstNameTextField.getText().isEmpty())
            notFilled = false;
        else
            edit.setFirstName(firstNameTextField.getText());


        if(lastNameTextField.getText().isEmpty())
            notFilled = false;
        else
            edit.setLastName(lastNameTextField.getText());


        if(fathersnameTextField.getText().isEmpty())
            notFilled = false;
        else
            edit.setFathersName(fathersnameTextField.getText());


        if(!yearOfBirth.getSelectionModel().isEmpty())
            edit.setDob(new Date((Integer)((yearOfBirth.getSelectionModel().getSelectedItem())) - 1900, edit.getDob().getMonth() , edit.getDob().getDay()));
        else{
            notFilled = false;
            edit.setDob(new Date(1999, edit.getDob().getMonth() , edit.getDob().getDay()));
        }


        if(!monthOfBirth.getSelectionModel().isEmpty())
            edit.setDob(new Date(edit.getDob().getYear(), ((Monthes)(monthOfBirth.getSelectionModel().getSelectedItem())).ordinal() , edit.getDob().getDay()));
        else{
            notFilled = false;
            edit.setDob(new Date(1999, edit.getDob().getMonth() , edit.getDob().getDay()));
        }



        if(!dayOfBirth.getSelectionModel().isEmpty())
            edit.setDob(new Date(edit.getDob().getYear(), edit.getDob().getMonth() , (Integer)dayOfBirth.getSelectionModel().getSelectedItem()));
        else{
            notFilled = false;
            edit.setDob(new Date(edit.getDob().getYear(), edit.getDob().getMonth() , 1));
        }



        if(maleBox.isSelected()) {
            edit.setGender(Gender.MALE);
        }else if(femaleBox.isSelected()) {
            edit.setGender(Gender.FEMALE);
        }else{
            notFilled = false;
           edit.setGender(Gender.MALE);
        }

        //address
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String address = addressTextField.getText();


        //contact info
        String tel = telTextField.getText();
        String phone = phoneTextField.getText();
        String mail = mailTextField.getText();
        String  fax = faxTextField.getText();



        //insurance

        TypeOfInsurance type;
        if(!typeOfInsurance.getSelectionModel().isEmpty())
            type = (TypeOfInsurance)(typeOfInsurance.getSelectionModel().getSelectedItem());
        else{
            type = TypeOfInsurance.TYPEA;
        }


        String insuranceId = insuranceIdTextField.getText();


        int yearEx;
        if(!yearOfEx.getSelectionModel().isEmpty())
            yearEx = (Integer)(yearOfEx.getSelectionModel().getSelectedItem());
        else
            yearEx = 2000;


        Monthes monthEx;
        if(!monthOfEx.getSelectionModel().isEmpty())
            monthEx = (Monthes)(monthOfEx.getSelectionModel().getSelectedItem());
        else
            monthEx = (Monthes.APRIL);

        if(!notFilled) {
            messeageLabel.setVisible(true);
        }
    }

    @FXML
    private void visitClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/visitPatient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (identifyNoTextField.getScene().getWindow());
            stage.setScene(scene);
            RegistPatientsController.patient = edit;
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
