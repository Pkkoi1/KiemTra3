package fit.Entity;

import java.util.ArrayList;

public class Benhnhan {
    private String id;
    private String firstName;
    private String lastName;
    private String bloodType;
    private String gender;

    private Address address;
    private ArrayList<String> telephone;
    private ArrayList<Tests> tests;
    private int yearOfBirth;

    public Benhnhan() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(ArrayList<String> telephone) {
        this.telephone = telephone;
    }

    public ArrayList<Tests> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Tests> tests) {
        this.tests = tests;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "benhnhan{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", telephone=" + telephone +
                ", tests=" + tests +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }


}
