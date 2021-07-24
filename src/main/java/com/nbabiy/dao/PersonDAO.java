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
        people.add(new Person(++PEOPLE_COUNT, "Tom", 36, "tom36@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jenny", 25, "jenny35@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alice", 19, "alice19@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vika", 19, "shy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(final int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(person.getName());
        toBeUpdated.setAge(person.getAge());
        toBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId()==id);
    }
}
