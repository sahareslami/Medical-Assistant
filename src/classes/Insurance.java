package classes;


import java.util.Date;

enum TypeOfInsurance{TYPEA , TYPEB , TYPEC};


public class Insurance{
    TypeOfInsurance type;
    String insuranceId;
    Date expirationDate;

    public Insurance(TypeOfInsurance type , String insuranceId , Date expirationDate){
        this.type = type;
        this.insuranceId = insuranceId;
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public TypeOfInsurance getType() {
        return type;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public String toString(){
        String result = "";
        result += type.name() + "\n";
        result += insuranceId + "\n";
        result += expirationDate ;
        return result;
    }
}