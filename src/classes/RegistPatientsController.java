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
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RegistPatientsController {
    public static Patient patient;

    //fill observable List

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
    ObservableList<Integer> yearAfter = FXCollections.observableArrayList(new Integer(2018) , new Integer(2019) , new Integer(2020) , new Integer(2021));

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
    private void initialize() {
        title.setItems(titleOfPatient);
        yearOfBirth.setItems(FXCollections.observableArrayList(fillYear()));
        monthOfBirth.setItems(month);
        dayOfBirth.setItems(FXCollections.observableArrayList(fillDay()));
        typeOfInsurance.setItems(typeOfIn);
        yearOfEx.setItems(yearAfter);
        monthOfEx.setItems(month);
    }

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
    public void save(){
        boolean notFilled = true;
        //personal info
        Title t;
        if(!title.getSelectionModel().isEmpty())
             t = (Title)(title.getSelectionModel().getSelectedItem());
        else {
            notFilled = false;
            t = (Title.Mr);
        }

        String identifyNo = identifyNoTextField.getText();
        if(identifyNoTextField.getText().isEmpty())
            notFilled = false;


        String firstName = firstNameTextField.getText();
        if(firstNameTextField.getText().isEmpty())
            notFilled = false;


        String lastName = lastNameTextField.getText();
        if(lastNameTextField.getText().isEmpty())
            notFilled = false;


        String fathersName = fathersnameTextField.getText();
        if(fathersnameTextField.getText().isEmpty())
            notFilled = false;


        int yearDOB;
        if(!yearOfBirth.getSelectionModel().isEmpty())
            yearDOB = (Integer) (yearOfBirth.getSelectionModel().getSelectedItem());
        else{
            notFilled = false;
            yearDOB = 1999;
        }


        Monthes monthDOB;
        if(!monthOfBirth.getSelectionModel().isEmpty())
            monthDOB = (Monthes)monthOfBirth.getSelectionModel().getSelectedItem();
        else{
            notFilled = false;
            monthDOB = Monthes.APRIL;
        }



        int dayDOB;
        if(!dayOfBirth.getSelectionModel().isEmpty())
            dayDOB = (Integer) (dayOfBirth.getSelectionModel().getSelectedItem());
        else{
            notFilled = false;
            dayDOB = 1;
        }


        Gender gender;
        if(maleBox.isSelected()) {
            gender = Gender.MALE;
        }else if(femaleBox.isSelected()) {
            gender = Gender.FEMALE;
        }else{
            notFilled = false;
            gender = Gender.FEMALE;
        }

        //address
        String state = stateTextField.getText();
        if(stateTextField.getText().isEmpty())
            state = "null";
        String city = cityTextField.getText();
        if(cityTextField.getText().isEmpty())
            city = "null";
        String address = addressTextField.getText();
        if(addressTextField.getText().isEmpty())
            address = "null";



        //contact info
        String tel = telTextField.getText();
        if(telTextField.getText().isEmpty())
            tel = "null";
        String phone = phoneTextField.getText();
        if(phoneTextField.getText().isEmpty())
            phone = "null";
        String mail = mailTextField.getText();
        if(mailTextField.getText().isEmpty())
            mail = "null";
        String  fax = faxTextField.getText();
        if(faxTextField.getText().isEmpty())
            fax = "null";



        //insurance

        TypeOfInsurance type;
        if(!typeOfInsurance.getSelectionModel().isEmpty())
            type = (TypeOfInsurance)(typeOfInsurance.getSelectionModel().getSelectedItem());
        else{
            type = TypeOfInsurance.TYPEA;
        }


        String insuranceId = insuranceIdTextField.getText();
        if(insuranceIdTextField.getText().isEmpty())
            insuranceId = "null";


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
        else {
            messeageLabel.setVisible(false);
            Date dob = new Date(yearDOB - 1900, monthDOB.ordinal() + 1, dayDOB);
            Date doEx = new Date(yearEx - 1900, monthEx.ordinal() + 1, 1);

            Contact contact = new Contact(mail, tel, phone, fax);
            Address adrs = new Address(state, city, address);
            Insurance insurance = new Insurance(type, insuranceId, doEx);


            System.out.println("before pp");
            Patient p = new Patient(t, firstName, lastName, fathersName,
                    dob, identifyNo, gender,
                    adrs, contact, insurance);
            p.saveInfo();
            ListOfPatient.add(p);
            patient = p;

        }

    }
    @FXML
    private void homeClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/doctorPage.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (identifyNoTextField.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void visitClicked(){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/fxml/visitPatient.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = (Stage) (identifyNoTextField.getScene().getWindow());
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
