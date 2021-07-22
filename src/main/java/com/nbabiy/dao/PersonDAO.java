package com.nbabiy.dao;

import com.nbabiy.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nazariibabii
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jenny"));
        people.add(new Person(++PEOPLE_COUNT, "Alice"));
        people.add(new Person(++PEOPLE_COUNT, "Vika"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(final int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
