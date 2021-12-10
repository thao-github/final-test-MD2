package model;

public class Contact {
    private String name;
    private String group;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
    private String email;

    public Contact() {
    }

    public Contact(String name, String group, String gender, String dateOfBirth, String phoneNumber, String address, String email) {
        this.name = name;
        this.group = group;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                name + ',' +
                group + ',' +
                gender + ',' +
                dateOfBirth + ',' +
                phoneNumber + ',' +
                address + ',' +
                email;
    }
}
