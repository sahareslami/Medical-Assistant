package classes;


import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Patient {


    int totalMoney;
    private File patient;
    private File info;


    private Title title;
    private String firstName,lastName;
    private String fathersName;

    private Address address;

    private Contact contact;


    private Date dob;
    private int age;

    private String id;
    private Gender gender;

    private Insurance insurance;

    List<Integer> cast = new ArrayList<>();


    List<Date> dateOfVisit = new ArrayList<>();
    List<String> description = new ArrayList<>();
    List<String> diagnosis = new ArrayList<>();
    List<List<Drug>> drugs = new ArrayList<>();

    List<File> visit = new ArrayList<>();
    List<File> descriptionFile = new ArrayList<>();
    List<File> diagnosisFile = new ArrayList<>();
    List<File> drugsFile = new ArrayList<>();

    public Patient(Title title ,String firstName,String lastName, String fathersName,
                   Date dob ,String id,Gender gender,
                   Address address,Contact contact,Insurance insurance){

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fathersName = fathersName;


        this.dob = dob;
        this.age = computeAge(dob);

        this.id = id;

        this.gender = gender;


        this.address = address;
        this.contact = contact;

        this.insurance = insurance;

        patient = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Patients/" + id);
        patient.mkdir();

        info = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Patients/" + id  + "/personalInformation.txt");

    }

    private int computeAge(Date d){
        Date now = new Date();
        int nowYear = now.getYear();
        int dYear = d.getYear();
        return (nowYear-dYear);
    }

    public void saveInfo(){
        try{
            PrintWriter writer = new PrintWriter(info);
            writer.print(title + " ");
            writer.println(firstName + " " + lastName);
            writer.println(fathersName);
            writer.println(age);
            writer.println(dob);
            writer.println(id);
            writer.println(gender.name());
            writer.println(address);
            writer.println(contact);

            if(insurance != null)
                writer.println(insurance);

            writer.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public String getFathersName() {
        return fathersName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }
    public Insurance getInsurance() {
        return insurance;
    }


    public void setTitle(Title title) {
        this.title = title;
        saveInfo();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        saveInfo();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        saveInfo();
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
        saveInfo();
    }

    public void setDob(Date dob) {
        this.dob = dob;
        saveInfo();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        saveInfo();
    }


    public void setId(String id){
        this.id = id;
        patient.renameTo(new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Patients/" + id));
        saveInfo();
    }


    public void visit(String description,String diagnosis,List<Drug> drugs,Date dateOfVisit,int cast){
        (this.description).add(description);
        (this.diagnosis).add(diagnosis);
        (this.drugs).add(drugs);
        (this.dateOfVisit).add(dateOfVisit);
        (this.cast).add(cast);
        File current = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Patients/" + id + "/" + nameOfLastFile());
        current.mkdir();
        (this.visit).add(current);



    }

    public void saveDescription(){
        File current = new File(visit.get(visit.size() - 1) , "description.txt");
        descriptionFile.add(current);
        try{
            PrintWriter writer = new PrintWriter(current);
            writer.print(description.get(description.size() - 1));
            writer.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public void saveDiagnosis(){
        File current = new File(visit.get(visit.size() - 1) , "diagnosis.txt");
        diagnosisFile.add(current);
        try{
            PrintWriter writer = new PrintWriter(current);
            writer.print(this.diagnosis.get(diagnosis.size() - 1));
            writer.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    private  String nameOfLastFile(){
        Date d = (this.dateOfVisit).get(this.dateOfVisit.size() - 1);
        String result = d.getYear() + "" + d.getMonth() + d.getDay();
        return result;
    }

    public void saveDrugs(){
        File current = new File(visit.get(visit.size() - 1) , "Drugs.txt");
        try {
            PrintWriter writer = new PrintWriter(current);
            System.out.println(((this.drugs).get((this.drugs).size() - 1)).size());
            for(Drug d : ((this.drugs).get((this.drugs).size() - 1)))
                writer.print(d + " ");
            writer.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveCast(){
        File current = new File(visit.get(visit.size() - 1) , "cast.txt");
        try{
            PrintWriter writer = new PrintWriter(current);
            writer.println(cast.get(cast.size() - 1));
            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void addTotalMoney(int money){
        totalMoney += money;
    }

    public List<File> getVisit() {
        return visit;
    }

    public List<Date> getDateOfVisit() {
        return dateOfVisit;
    }

    public List<String> getDescription() {
        return description;
    }

    public List<String> getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return id;
    }
}
