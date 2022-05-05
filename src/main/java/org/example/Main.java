package org.example;

import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        fillPhoneBook(myPhoneBook);
        MissedCalls missedCalls = new MissedCalls();
        missedCalls.addMissedCalls("986369");
        missedCalls.addMissedCalls("366429");
        missedCalls.addMissedCalls("148863");
        missedCalls.addMissedCalls("097326");
        missedCalls.addMissedCalls("785113");
        missedCalls.addMissedCalls("234556");

        missedCalls.showMissedCalls(myPhoneBook);
    }

    public static void fillPhoneBook(PhoneBook phoneBook) {
        Contact contact1 = new Contact("Jack from office", "234556");
        Contact contact2 = new Contact("Jane friend", "651178");
        Contact contact3 = new Contact("Michael colleague", "148863");
        Contact contact4 = new Contact("Mother", "984120");
        Contact contact5 = new Contact("Nick", "785113");

        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);
        phoneBook.addContact(contact3);
        phoneBook.addContact(contact4);
        phoneBook.addContact(contact5);
    }
}
