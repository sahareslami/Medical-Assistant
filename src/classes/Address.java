package classes;

public class Address{
    private String state;
    private String city;
    private String address;

    public Address(String state,String city,String address){
        this.state = state;
        this.city = city;
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


    public void editState(String state){
        this.state = state;
    }
    public void editCity(String city){
        this.city = city;
    }
    public void editAddress(String address){
        this.address = address;
    }

    public String toString(){
        String result = (address);
        result += ("\n" +city);
        result += ("\n" +state);
        return result;
    }
}
