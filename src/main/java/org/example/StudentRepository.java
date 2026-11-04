package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository  {

    private final Connection conn ;

    @Qualifier("undergraduate")
    private Student undergraduate;

    public StudentRepository(DatabaseConnection databaseConnection , @Qualifier("undegraduate") Student undergraduate) throws SQLException {
        this.conn = databaseConnection.databaseConnection();
        this.undergraduate = undergraduate;
    }
    public void createTable() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("""
             create table student(
                 id serial primary key,
                 name varchar(25),
                 age int,
                 gender varchar(2)
             )""");
    }

    public String addStudent(Student student) throws SQLException {
        String insertSql = "INSERT INTO student(name, gender, age) VALUES (?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSql);

        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getGender());
        preparedStatement.setInt(3, student.getAge());

        preparedStatement.executeUpdate();
        return student.getName()+ "has successfully added";
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String selectSql = "SELECT * FROM student";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            students.add(new Student(name,age,gender));
        }
        return students;
    }
    public Student getStudent(String studentName) throws SQLException {
        String selectSql = "SELECT * FROM stude nts WHERE name = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(selectSql);
        preparedStatement.setString(1, studentName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            return new Student(name,age,gender);
        }
        return null;
    }
}
