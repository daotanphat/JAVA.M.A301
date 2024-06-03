package fa.training.service;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    Validator validator = new Validator();
    List<Person> persons = new ArrayList<Person>();
    Scanner sc = new Scanner(System.in);

    public List<Person> addPersons() {
        int numberPersons = validator.inputInt("Enter number of persons need to add: ", 1, Integer.MAX_VALUE);
        int personType = validator.inputInt("Enter 1 to add student or 2 to add teacher: ", 1, 2);
        for (int i = 0; i < numberPersons; i++) {
            String name = validator.inputStrNoBlank("Enter name: ");
            String gender = validator.inputStrNoBlank("Enter gender: ");
            String phoneNumber = validator.inputStrNoBlank("Enter phone number: ");
            String email;
            do {
                System.out.print("Enter email: ");
                email = sc.nextLine();
            } while (validator.isValidEmail(email));
            switch (personType) {
                case 1:
                    String studentId = validator.inputStrNoBlank("Enter student ID: ");
                    double theory = validator.inputMark(0, 10, "Enter theory: ");
                    double practice = validator.inputMark(0, 10, "Enter practice: ");
                    Student student = new Student(name, gender, phoneNumber, email, studentId, theory, practice);
                    persons.add(student);
                    break;
                case 2:
                    double salary = validator.inputMark(0, Integer.MAX_VALUE, "Enter salary: ");
                    double subsidy = validator.inputMark(0, Integer.MAX_VALUE, "Enter subsidy: ");
                    Teacher teacher = new Teacher(name, gender, phoneNumber, email, salary, subsidy);
                    persons.add(teacher);
                    break;
            }
        }
        return persons;
    }
}
