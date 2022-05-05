package org.example;

import java.util.Objects;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Contact.class)) {
            return false;
        }

        Contact contact = (Contact) obj;

        return phoneNumber == contact.phoneNumber;
    }

    @Override
    public String toString() {
        return "Name=" + name + ", phoneNumber=" + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void validatePhoneNumber() {
        if (this.phoneNumber.isBlank()) {
            throw new RuntimeException("Phone Name Cannot be null or empty");
        }

        if (!this.phoneNumber.matches("\\d+")) {
            throw new RuntimeException("Phone Number Contain only digits");
        }
    }

    public void validateName() {
        if (this.name.isBlank())
            throw new RuntimeException("First Name Cannot be null or empty");
    }
}
