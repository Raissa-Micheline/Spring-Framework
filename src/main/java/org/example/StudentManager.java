package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentManager {

    private StudentRepository repository;

       public StudentManager(StudentRepository repository) throws SQLException {
        this.repository = repository ;
    }

    public void createTable() throws SQLException {
        repository.createTable();
    }


    public String save(Student student) throws SQLException {
       return repository.addStudent(student);
    }
    public List<Student> retrieveAll() throws SQLException {
        return repository.getAllStudents();
    }
    public Student retrieveStudent(String name) throws SQLException {
        return repository.getStudent(name);
    }

}
