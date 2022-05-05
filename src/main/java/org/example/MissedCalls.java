package org.example;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalls(String number) {
        missedCalls.put(LocalDateTime.now(), number);
    }

    public void showMissedCalls(PhoneBook phoneBook) {
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            LocalDateTime key = entry.getKey();
            String number = entry.getValue();

            if (phoneBook.getContacts().contains((phoneBook.findContactByNumber(number)))) {
                number = phoneBook.findContactByNumber(number).getName();
            }
            System.out.println(key + "; " + number);
        }
    }
}
