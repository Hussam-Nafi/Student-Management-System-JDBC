package com.hussam;

import com.hussam.dao.StudentDAO;
import com.hussam.model.Student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        List<Student> list = studentDAO.getAllStudents(); // SELECT
        System.out.println(list);

        // studentDAO.insertStudent(107 , "Jana Nafi" , "jananafi016@gmail.com" ,"0798503245" ,Date.valueOf("2016-08-31"), 20 , 20 , 40); //INSERT

        // studentDAO.updateStudent(104, "Shouqi Nafi" , "shouqinafi006@gmail.com" , "0796584123" ,Date.valueOf("2006-06-06"), 20 , 20 , 40 ); //UPDATE

        // studentDAO.deleteStudent(106); //DELETE

        Student student = studentDAO.searchStudentById(103);
        System.out.println(student);
    }
}