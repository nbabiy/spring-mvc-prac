package com.nbabiy.dao;

import com.nbabiy.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nazariibabii
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM PERSON";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));
                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(final int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() + "'" +
                    "," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person person) {
//        Person toBeUpdated = show(id);
//        toBeUpdated.setName(person.getName());
//        toBeUpdated.setAge(person.getAge());
//        toBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(p -> p.getId()==id);
    }
}
