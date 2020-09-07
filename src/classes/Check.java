package classes;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Check{
    public static void main(String[] args){

        /*Patient p = new Patient(Title.Mr , "sahar" , "eslami" , "abbas" , new Date(99 , 12 , 31) , "96127" , Gender.FEMALE ,
                new Address("khorasan" , "mashhhad" , "ahmadAbad"),
                new Contact("0915109" , "seslami" , "this" , "98888"));
*/
        Patient q = new Patient(Title.Mr , "sahar" , "eslami" , "abbas" , new Date(105 , 12 , 31) , "95127" , Gender.FEMALE ,
                new Address("khorasan" , "mashhhad" , "ahmadAbad"),
                new Contact("0915109"),
                new Insurance(TypeOfInsurance.TYPEA , "1919191" , new Date(105 , 10 , 10)));
        List<Drug> d = new ArrayList<Drug>();
        d.add(new Drug("ali" , "gholi" , "hassan" , "reza"));
        d.add(new  Drug("1" , "2" , "3" , "4"));
        q.visit("hello" , "mello" , d , new Date() , 100);
        q.saveDescription();
        q.saveDiagnosis();
        q.saveDrugs();
        q.visit("VALI" , "ALI" , d , new Date(100 , 2 , 2) , 10);
        q.saveDescription();
        q.saveDiagnosis();
        q.saveDrugs();

    }

}