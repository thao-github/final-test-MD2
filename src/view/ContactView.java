package view;

import model.Contact;
import service.Validate;

import java.util.Scanner;

public class ContactView {
    Scanner scanner = new Scanner(System.in);

    public int menuContact(){
        System.out.println("---CONTACT MANAGEMENT---");
        System.out.println("Enter 1 ~ 8 to continue.");
        System.out.println("1. DISPLAY Contact List");
        System.out.println("2. ADD New Contact");
        System.out.println("3. UPDATE Contact");
        System.out.println("4. DELETE Contact");
        System.out.println("5. SEARCH Contact");
        System.out.println("6. READ File Contact");
        System.out.println("7. WRITE To File");
        System.out.println("8. EXIT");
        System.out.println("----------");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public Contact createNewContact() {
        String name = Validate.validate("Enter name: ", Validate.NAME_REGEX);
        String group = Validate.validate("Enter group: ", Validate.GROUP_REGEX);
        String gender = Validate.validate("Enter gender: ", Validate.GENDER_REGEX);
        String dateOfBirth = Validate.validate("Enter date of Birth: ", Validate.DATE_OF_BIRTH_REGEX);
        String phoneNumber = Validate.validate("Enter phone number: ", Validate.PHONE_NUMBER_REGEX);
        String address = Validate.validate("Enter address: ", Validate.ADDRESS_REGEX);
        String email = Validate.validate("Enter email: ", Validate.EMAIL_REGEX);
        return new Contact(name, group, gender, dateOfBirth, phoneNumber, address, email);

    }
    public void alertAddSuccess() {
        System.out.println("Contact Add Success!");
    }
    //3 edit
    public String inputPhoneNumber() {
        System.out.println("Enter phone Number: ");
        return scanner.nextLine();
    }

    public String alertContactNotExist(){
        System.err.println("Contact NOT Exist!");
        System.out.println("Press ANY KEY to continue. Or Press ENTER to Back to Menu.");
        return scanner.nextLine();
    }

    public void alertEditSuccess(){
        System.out.println("EDIT Success!");
    }

    public String confirmDelete(){
        System.out.println("Are you sure to Delete Student? Press Y to confirm " +
                "Or Press ANY KEY to BACK to Menu");
        return scanner.nextLine();
    }

    public String inputNameToSearch(){
        System.out.println("Enter name:");
        return scanner.nextLine();
    }
}
