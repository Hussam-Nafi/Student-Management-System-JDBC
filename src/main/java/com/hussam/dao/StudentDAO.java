package com.hussam.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hussam.db.DBConnection;
import com.hussam.model.Student;

public class StudentDAO {

    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("student_id_number"),
                rs.getString("student_name"),
                rs.getString("student_email"),
                rs.getString("student_phone"),
                rs.getDate("student_birthday"),
                rs.getInt("student_first_mark"),
                rs.getInt("student_second_mark"),
                rs.getInt("student_final_mark")
        );
    }
    // SELECT
    public List<Student> getAllStudents() {
        String SQL = "SELECT * FROM public.students";
        List<Student> listOfStudent = new ArrayList<Student>();

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while(resultSet.next()) {
                Student student = mapResultSetToStudent(resultSet);
                listOfStudent.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfStudent;
    }

    // INSERT
    public int insertStudent(int id, String name, String email, String phone, Date birthday, int firstMark, int secondMark, int finalMark) {
        String SQL = "INSERT INTO public.students VALUES(? , ? , ? , ? , ? , ? , ? , ?)";
        int rows = 0;
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ) {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,phone);
            preparedStatement.setDate(5,birthday);
            preparedStatement.setInt(6,firstMark);
            preparedStatement.setInt(7,secondMark);
            preparedStatement.setInt(8,finalMark);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // UPDATE
    public int updateStudent(int id, String name, String email, String phone, Date birthday, int firstMark, int secondMark, int finalMark) {
        String SQL = "UPDATE public.students SET student_name = ? ,student_email = ? ,student_phone = ? , student_birthday = ? ,student_first_mark = ? ,student_second_mark = ? ,student_final_mark = ? WHERE student_id_number = ?";
        int rows = 0;
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phone);
            preparedStatement.setDate(4,birthday);
            preparedStatement.setInt(5,firstMark);
            preparedStatement.setInt(6,secondMark);
            preparedStatement.setInt(7,finalMark);
            preparedStatement.setInt(8,id);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //DELETE
    public int deleteStudent(int id) {
        String SQL = "DELETE FROM public.students WHERE student_id_number = ?";
        int rows = 0;
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ) {
            preparedStatement.setInt(1, id);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //Search Student By Id
    public Student searchStudentById(int id) {
        String SQL = "SELECT * FROM public.students WHERE student_id_number = ?";
        Student student = null;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                student = mapResultSetToStudent(resultSet);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
