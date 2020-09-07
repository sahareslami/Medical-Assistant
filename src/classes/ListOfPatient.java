package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListOfPatient{


    public static int numberOfPatients;
    static File listOfPatientFile = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes//ListOfPatient/list");
    public static List<Patient> listOfPatient = new ArrayList<>();
    public static int total;



    public static void makeObject(){
        try {
            Scanner scan = new Scanner(listOfPatientFile);
            while (scan.hasNext()) {
                String p = scan.next();
                File currentPatient = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Patients/" + p + "/personalInformation.txt");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", new Locale("us"));
                    Scanner scanPatient = new Scanner(currentPatient);


                    //personal info
                    String t = scanPatient.next();
                    Title title = Title.valueOf(t);
                    String firstName = scanPatient.next();
                    String lastName = scanPatient.next();
                    String fathersName = scanPatient.next();
                    String age = scanPatient.next();
                    scanPatient.nextLine();
                    String dob = scanPatient.nextLine();
                    Date dateofBirth;

                    try {
                        dateofBirth = sdf.parse(dob);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        dateofBirth = new Date();
                    }
                    String id = scanPatient.next();
                    String g = scanPatient.next();
                    Gender gender = Gender.valueOf(g);




                    //address
                    String address = scanPatient.next();
                    String city = scanPatient.next();
                    String state = scanPatient.next();


                    Address adr = new Address(state, city, address);


                    //contact info
                    String phone = scanPatient.next();
                    String email = scanPatient.next();
                    String tel = scanPatient.next();
                    String fax = scanPatient.next();

                    Contact contact = new Contact(email, tel, phone, fax);

                    //insurance
                    String type = scanPatient.next();
                    TypeOfInsurance toi = TypeOfInsurance.valueOf(type);
                    String insuranceId = scanPatient.next();
                    if(insuranceId != null)
                        scanPatient.nextLine();
                    String dEx = scanPatient.nextLine();

                    Date dateofEx;
                    try {
                        dateofEx = sdf.parse(dEx);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        dateofEx = new Date();
                    }

                    Insurance ins = new Insurance(toi, insuranceId, dateofEx);



                    listOfPatient.add(new Patient(title, firstName, lastName, fathersName,
                            dateofBirth, id, gender,
                            adr, contact, ins));

                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void add(Patient p){
        numberOfPatients++;
        listOfPatient.add(p);
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(listOfPatientFile , true));
            writer.print(p.getId()+ " ");
            writer.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
