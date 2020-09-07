package classes;

public class Contact{
    String mail;
    String tel;
    String phone;
    String fax;

    public Contact(String mail , String tel , String phone , String fax){
        this.mail = mail;
        this.tel = tel;
        this.phone = phone;
        this.fax = fax;
    }

    public Contact(String phone){
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public String getPhone() {
        return phone;
    }

    public String toString(){
        String result = phone ;
        result += ("\n" + mail );
        result += ("\n" +tel );
        result+= ("\n" +fax );
        return result;
    }
}
