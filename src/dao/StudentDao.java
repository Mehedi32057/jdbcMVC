package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String URL = "jdbc:mysql://localhost:3306/student_dob";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void addStudent(Student student) {
        String query = "INSERT INTO student(name,email,age) VALUES(?,?,?)";
        try (Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
             PreparedStatement stmt= conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2,student.getEmail());
            stmt.setInt(3,student.getAge());
            stmt.executeUpdate();
            System.out.println("student add successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Student>getAllStudent(){
        List<Student> students= new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
             Statement stmt= conn.createStatement();
             ResultSet rs=stmt.executeQuery(query)){
            while (rs.next()){
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
      return students;
    }
    public void updateStudent(int id, String name, String email, int age){
        String query="UPDATE student SET name=?,email=?,age=? WHERE id=?";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.setInt(3,age);
            stmt.setInt(4,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected>0){
                System.out.println("student update successfully");
            }
            else {
                System.out.println("student not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteStudent(int id){
        String query ="DELETE FROM student WHERE id=?";
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement stmt= conn.prepareStatement(query)){
            stmt.setInt(1,id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected>0){
                System.out.println("student deleted successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}