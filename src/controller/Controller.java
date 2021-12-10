package controller;

import model.Contact;
import service.ContactService;
import view.ContactView;

public class Controller {
    static ContactView contactView = new ContactView();
    static ContactService contactService = new ContactService();

    public static void contactController() {
        while (true) {
            int choice = contactView.menuContact();
            switch (choice) {
                case 1: {
                    contactService.displayContactList();
                    break;
                }
                case 2: {
                    Contact contact = contactView.createNewContact();
                    contactService.save(contact);
                    contactView.alertAddSuccess();
                    break;
                }
                case 3: {
                    while (true) {
                        String phoneNumber = contactView.inputPhoneNumber();
                        int index = contactService.findIndexByPhoneNumber(phoneNumber);

                        if (index == -1) {
                            String select = contactView.alertContactNotExist();
                            if (select.trim().equals("")) {
                                Controller.contactController();
                                break;
                            }
                        } else {
                            Contact contact = contactView.createNewContact();
                            contactService.editContact(index, contact);
                            contactView.alertEditSuccess();
                            break;
                        }
                    }
                    break;
                }

                case 4: {
                    while (true) {
                        String phoneNumber = contactView.inputPhoneNumber();
                        int index = contactService.findIndexByPhoneNumber(phoneNumber);

                        if (index == -1) {
                            String select = contactView.alertContactNotExist();
                            if (select.trim().equals("")) {
                                Controller.contactController();
                                break;
                            }
                        } else {
                            String choose = contactView.confirmDelete();
                            if (choose.equalsIgnoreCase("Y")) {
                                contactService.deleteContact(index);
                                contactService.displayContactList();
                                break;
                            } else {
                                Controller.contactController();
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    String name = contactView.inputNameToSearch();
                    int index = contactService.searchIndexByName(name);
                    contactService.searchByName(index);
                    break;
                }
                case 6: {
                    contactService.readFile(contactService.CONTACT_LIST_PATH);
                    break;
                }
                case 7: {
                    contactService.writeFile(contactService.CONTACT_LIST_PATH, contactService.findAll());
                    break;
                }
                case 8: {
                    System.exit(8);
                    break;
                }
            }
        }
    }
}
