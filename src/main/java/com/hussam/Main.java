package com.hussam;

// import package -- step 1
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Import Package");

        String url = "jdbc:postgresql://localhost:5432/SQL_Course";
        String username = "postgres";
        String password = "0000";

        String selectSQL = "SELECT * FROM public.students";

        // Load And Register -- step 2 and 3
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Load And Register Success");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create Connection -- step 4 , Create Statement -- step 5 , Execute Statement -- step 6 , Close Connection -- step 7
        // SELECT
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            System.out.println("Create Connection Success");
            System.out.println("Create Prepared Statement Success");
            System.out.println("Execute Statement Success");

            int studentId;
            String studentName;
            String studentEmail;
            String studentPhone;
            Date studentBirthday;
            int studentFirstMark;
            int studentSecondMark;
            int studentFinalMark;

            System.out.println("Result is : ");
            System.out.println("***********************************************************************************************************************************************************************");
            System.out.println("student_id_number \t student_name \t student_email \t \t \t \t student_phone \t student_birthday \t student_first_mark \t student_second_mark \t student_final_mark");
            while(resultSet.next()) {
                studentId = resultSet.getInt("student_id_number");
                studentName = resultSet.getString("student_name");
                studentEmail = resultSet.getString("student_email");
                studentPhone = resultSet.getString("student_phone");
                studentBirthday = resultSet.getDate("student_birthday");
                studentFirstMark = resultSet.getInt("student_first_mark");
                studentSecondMark = resultSet.getInt("student_second_mark");
                studentFinalMark = resultSet.getInt("student_final_mark");

                System.out.println(studentId + " \t \t \t \t " + studentName + " \t " + studentEmail + " \t " + studentPhone + " \t " + studentBirthday + " \t \t " + studentFirstMark + " \t \t \t \t \t " + studentSecondMark + " \t \t \t \t \t " + studentFinalMark);
            }
            System.out.println("***********************************************************************************************************************************************************************");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Statement
        String insertSQLOne = "INSERT INTO public.students VALUES(104 , 'Sameer' , 'sameerNafi069@gmail.com' , '0796584123' , '08-29-1969' , 20 , 20 , 40)";
        String insertSQLTwo = "INSERT INTO public.students VALUES(105 , 'Jana' , 'jananafi@gmail.com' , '0796452771' , '08-31-2016' , 20 , 20 , 40)";

        // PreparedStatement
        String insertSQLThree = "INSERT INTO public.students VALUES(? , ? , ? , ? , ? , ? , ? , ?)";

        // Create Connection -- step 4 , Create Statement -- step 5 , Execute Statement -- step 6 , Close Connection -- step 7
        // INSERT
        /*
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQLThree);
        ) {
            System.out.println("Create Connection Success");
            System.out.println("Create Prepared Statement Success");
            System.out.println("Execute Statement Success");

            // insert -> (106 , 'Ahmed Nafi' , 'ahmednafi01@gmail.com' , '0787419694' , '07-25-2008' , 16 , 18 , 32)

            preparedStatement.setInt(1,106);
            preparedStatement.setString(2,"Ahmed Nafi");
            preparedStatement.setString(3,"ahmednafi01@gmail.com");
            preparedStatement.setString(4,"0787419694");
            preparedStatement.setDate(5,new Date(2008 , 7 , 25));
            preparedStatement.setInt(6,16);
            preparedStatement.setInt(7,18);
            preparedStatement.setInt(8,32);

            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */

        // Statement
        String updateSQLOne = "UPDATE public.students SET student_name = 'Sameer Nafi' WHERE student_id_number = 104";

        // PreparedStatement
        String updateSQLTwo = "UPDATE public.students SET student_email = ? , student_birthday = ? WHERE student_id_number = ?";

        // Create Connection -- step 4 , Create Statement -- step 5 , Execute Statement -- step 6 , Close Connection -- step 7
        // UPDATE
        /*
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(updateSQLTwo);
        ) {
            System.out.println("Create Connection Success");
            System.out.println("Create Prepared Statement Success");
            System.out.println("Execute Statement Success");

            // update -> ('ahmednafi010@gmail.com' , '2008-07-25' , 106)

            preparedStatement.setString(1,"ahmednafi010@gmail.com");
            preparedStatement.setDate(2,Date.valueOf("2008-07-25"));
            preparedStatement.setInt(3,106);

            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */

        // Statement
        String deleteSQLOne = "DELETE FROM public.students WHERE student_id_number = 105";

        // PreparedStatement
        String deleteSQLTwo = "DELETE FROM public.students WHERE student_id_number = ?";

        // Create Connection -- step 4 , Create Statement -- step 5 , Execute Statement -- step 6 , Close Connection -- step 7
        // DELETE
        /*
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQLTwo);
        ) {
            System.out.println("Create Connection Success");
            System.out.println("Create Prepared Statement Success");
            System.out.println("Execute Statement Success");

            // delete -> (106)
            preparedStatement.setInt(1,106);

            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */
    }
}