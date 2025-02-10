package controller;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService= new StudentService();
    private Scanner scanner= new Scanner(System.in);

    public void menu(){
        while (true){
            System.out.println("\n student management system");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
scanner.nextLine();
switch (choice){

    case 1-> addStudent();
    case 2 -> viewStudents();
    case 3 -> updateStudent();
    case 4 -> deleteStudent();
    case 5 -> {
        System.out.println("🚀 Exiting...");
        return;
    }
    default -> System.out.println("⚠️ Invalid choice! Try again.");

}
        }
    }
    private void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        studentService.addStudent(new Student(0, name, email, age));
    }
    private void viewStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }
    private void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Email: ");
        String email = scanner.nextLine();
        System.out.print("New Age: ");
        int age = scanner.nextInt();
        studentService.updateStudent(id, name, email, age);
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
    }


}
