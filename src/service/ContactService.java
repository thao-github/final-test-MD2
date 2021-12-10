package service;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
    Scanner scanner = new Scanner(System.in);
    public final String CONTACT_LIST_PATH = "contactList.csv";
    List<Contact> contactList = readFile(CONTACT_LIST_PATH);

    public List<Contact> findAll(){
        return contactList;
    }

    public void displayContactList(){
        for (int i = 0; i < contactList.size(); i++){
            if (i% 5 == 0 && i !=0){
                scanner.nextLine();
            }
            System.out.println(contactList.get(i));
        }
    }

    public void save(Contact contact){
        contactList.add(contact);
        readFile(CONTACT_LIST_PATH);
    }

    public void editContact(int index, Contact contact){
        contactList.set(index, contact);
        readFile(CONTACT_LIST_PATH);
    }

    public int findIndexByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++){
            if (phoneNumber.equals(contactList.get(i).getPhoneNumber())) {
                return i;
            }
        }
        return -1;
    }

    public void deleteContact(int index){
        contactList.remove(index);
        readFile(CONTACT_LIST_PATH);
    }

    public int searchIndexByName(String name) {
        for (int i = 0; i < contactList.size(); i++){
            if (name.equals(contactList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
    public void searchByName(int index){
        System.out.println(contactList.get(index));
    }



    //6 read File
    public List<Contact> readFile(String FILE_PATH) {
        List<Contact> contactList = new ArrayList<>();
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine())!=null){
                String[] str  = line.split(",");
                String name = str[0];
                String group = str[1];
                String gender  = str[2];
                String dateOfBirth = str[3];
                String phoneNumber = str[4];
                String address = str[5];
                String email = str[6];
                Contact contact = new Contact(name, group, gender, dateOfBirth, phoneNumber,address, email);
                contactList.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    //7 Write File
    public void writeFile(String filePath, List<Contact> list){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
