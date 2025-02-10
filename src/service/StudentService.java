package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public void addStudent(Student student){
        studentDao.addStudent(student);

    }
    public List<Student>getAllStudents(){
        return studentDao.getAllStudent();
    }
    public void updateStudent(int id,String name, String email, int age){
        studentDao.updateStudent(id, name, email, age);

    }
    public void deleteStudent(int id){
        studentDao.deleteStudent(id);
    }
}
