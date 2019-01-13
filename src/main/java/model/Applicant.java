package model;

public class Applicant {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int applicationNumber;

    public Applicant(String firstName, String last_name, String phone_number, String email, int application_number) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.phoneNumber = phone_number;
        this.email = email;
        this.applicationNumber = application_number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getApplicationNumber() {
        return applicationNumber;
    }
}
