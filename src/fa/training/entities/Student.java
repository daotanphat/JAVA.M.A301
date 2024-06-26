package fa.training.entities;

public class Student extends Person {
    private String studentId;
    private double theory;
    private double practice;

    public Student(String name, String gender, String phoneNumber, String email,
                   String studentId, double theory, double practice) {
        super(name, gender, phoneNumber, email);
        this.studentId = studentId;
        this.theory = theory;
        this.practice = practice;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    public double calculateFinalMark() {
        return (practice + theory) / 2;
    }

    @Override
    void purchaseParkingPass() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "Student ID = " + studentId + ", name = " + name + ",  Final Mark = " + calculateFinalMark() + + '\'' +
                '}';
    }
}
