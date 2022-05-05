package org.example;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts = new ArrayList<>();

    public Contact findContactByNumber(String number) {
        for (Contact contact : contacts) {
            if (number.equals(contact.getPhoneNumber())) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public boolean addContact(Contact contact) {
        validateContact(contact);
        return contacts.add(contact);
    }

    private void validateContact(Contact contact) {
        contact.validateName();
        contact.validatePhoneNumber();
    }

    public int getPhoneBookSize() {
        return contacts.size();
    }
}
