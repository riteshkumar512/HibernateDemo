package in.kumar.HibernateDemo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String house_no;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address(){};

    public Address(String house_no, String street, String city, String state, String pincode) {
        this.house_no = house_no;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
