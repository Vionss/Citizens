package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTest {
    Citizens citizens;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        Person p1 = new Person(1, "F1", "L1", LocalDate.of(1991, 10, 3));
        Person p2 = new Person(2, "F2", "L2", LocalDate.of(1992, 11, 4));
        Person p3 = new Person(3, "F3", "L3", LocalDate.of(1993, 12, 5));
        Person p4 = new Person(4, "F4", "L4", LocalDate.of(1994, 12, 5));
        Person p5 = new Person(5, "F5", "L5", LocalDate.of(1995, 12, 5));
        citizens.add(p1);
        citizens.add(p2);
        citizens.add(p3);
        citizens.add(p4);
        citizens.add(p5);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Person p4 = new Person(4, "F4", "L4", LocalDate.of(1994, 4, 6));
        assertTrue(citizens.add(p4));
        assertEquals(6, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertTrue(citizens.remove(2));
        assertEquals(4, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void find1() {
        Person p4 = new Person(4, "F4", "L4", LocalDate.of(1994, 4, 6));
        citizens.add(p4);
        assertEquals(p4, citizens.find(4));
    }

    @org.junit.jupiter.api.Test
    void findMinMaxAge() {
        citizens = new CitizensImpl();
        Person p2 = new Person(2, "F2", "L2", LocalDate.of(1992, 11, 4));
        Person p3 = new Person(3, "F3", "L3", LocalDate.of(1993, 12, 5));
        citizens.add(p2);
        citizens.add(p3);

        Iterable<Person> expected = (Iterable<Person>) citizens;
        Iterable<Person> actual = citizens.find(31, 32);
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void findByLastName() {
        citizens = new CitizensImpl();
        Person p1 = new Person(1, "F1", "L1", LocalDate.of(1991, 10, 3));
        Person p2 = new Person(2, "F2", "L2", LocalDate.of(1992, 11, 4));
        Person p3 = new Person(3, "F3", "L3", LocalDate.of(1993, 12, 5));
        Person p4 = new Person(4, "F4", "L4", LocalDate.of(1994, 12, 5));
        Person p5 = new Person(5, "F5", "L5", LocalDate.of(1995, 12, 5));
        citizens.add(p1);
        citizens.add(p2);
        citizens.add(p3);
        citizens.add(p4);
        citizens.add(p5);
        List<Person> expected = new LinkedList<>();
        expected.add(p3);
        Iterable<Person> actual = citizens.find("L3");
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsById() {
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsByAge() {
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsByLastName() {
        citizens = new CitizensImpl();
        Person p1 = new Person(1, "F3", "L1", LocalDate.of(1991, 10, 3));
        Person p2 = new Person(2, "F1", "L2", LocalDate.of(1992, 11, 4));
        Person p3 = new Person(3, "F4", "L3", LocalDate.of(1993, 12, 5));
        Person p4 = new Person(4, "F5", "L4", LocalDate.of(1994, 12, 5));
        Person p5 = new Person(5, "F2", "L5", LocalDate.of(1995, 12, 5));
        citizens.add(p1);
        citizens.add(p2);
        citizens.add(p3);
        citizens.add(p4);
        citizens.add(p5);
        List<Person> expected = List.of(p2, p5, p1, p3, p4);

        Iterable<Person> actual = List.of(
                new Person(1, "F3", "L1", LocalDate.of(1991, 10, 3)),
                new Person(2, "F1", "L2", LocalDate.of(1992, 11, 4)),
                new Person(3, "F4", "L3", LocalDate.of(1993, 12, 5)),
                new Person(4, "F5", "L4", LocalDate.of(1994, 12, 5)),
                new Person(5, "F2", "L5", LocalDate.of(1995, 12, 5)));
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(5,citizens.size());
    }
}