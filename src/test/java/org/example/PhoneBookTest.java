package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    public void setup() {
        phoneBook = new PhoneBook();
    }

    @Test
    void testAddContact_invalidArgument_throwsRE() {
        // given:
        Contact contact1 = new Contact("Philip", null);
        Contact contact2 = new Contact("", "654567");
        Contact contact3 = new Contact("John", "+256108");

        // expect:
        Assertions.assertThrows(RuntimeException.class, () -> phoneBook.addContact(contact1));
        Assertions.assertThrows(RuntimeException.class, () -> phoneBook.addContact(contact2));
        Assertions.assertThrows(RuntimeException.class, () -> phoneBook.addContact(contact3));
    }

    @Test
    void testAddContact_validArgument_success() {
        // given:
        Contact contact = new Contact("Philip", "327725");

        // expect:
        Assertions.assertTrue(phoneBook.addContact(contact));
    }

    @Test
    void shouldAddContact() {
        // given:
        Contact contact1 = new Contact("Philip", "327725");

        // when:
        phoneBook.addContact(contact1);

        // expect:
        Assertions.assertEquals(1, phoneBook.getPhoneBookSize());
        Assertions.assertNotEquals(0, phoneBook.getPhoneBookSize());
        Assertions.assertTrue(phoneBook.getContacts().stream()
                .anyMatch(contact -> contact.getName().equals("Philip") && contact.getPhoneNumber().equals("327725")));
    }

    @Test
    void shouldGetContacts() {
        // given:
        Contact contact = new Contact("Philip", "327725");

        // when:
        phoneBook.addContact(contact);

        // expect:
        Assertions.assertFalse(phoneBook.getContacts().isEmpty());
    }

    @Test
    void shouldFindContactByNumber() {
        // given:
        Contact contact = new Contact("Philip", "327725");
        String number = "327725";

        phoneBook.addContact(contact);

        // expect:
        Assertions.assertEquals(contact, phoneBook.findContactByNumber(number));
    }

    @Test
    void testFindContactByNumber_noSuchContact_returnsNull() {
        // given:
        Contact contact = new Contact("Philip", "327725");
        String number = "271949";

        phoneBook.addContact(contact);

        // expect:
        Assertions.assertNull(phoneBook.findContactByNumber(number));
    }

    @Test
    void givenContacts_whenChecksSize_thenCorrect() {
        phoneBook.addContact(new Contact("Philip", "467822"));
        phoneBook.addContact(new Contact("Jane", "654567"));
        phoneBook.addContact(new Contact("John", "256108"));
        phoneBook.addContact(new Contact("Jack", "988264"));

        assertThat(phoneBook.getContacts(), hasSize(4));
    }

    @Test
    void contacts_whenEmpty_thenCorrect() {
        assertThat(phoneBook.getContacts(), empty());
    }

    @ParameterizedTest
    @MethodSource("contactList")
    void givenAContact_isPresent(Contact contact) {
        Contact contact1 = new Contact("Philip", "327725");

        phoneBook.addContact(contact);

        assertThat(phoneBook.getContacts(), hasItem(contact));
        assertThat(phoneBook.getContacts(), not(hasItem(contact1)));
    }

    private static List<Contact> contactList() {
        return Arrays.asList(new Contact("Philip", "467822"),
                new Contact("Jane", "654567"),
                new Contact("John", "256108"),
                new Contact("Jack", "988264"));
    }
}