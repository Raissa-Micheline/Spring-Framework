package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {


        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        StudentManager studentManager = context.getBean(StudentManager.class);


        System.out.println(studentManager.retrieveAll());
    }
}