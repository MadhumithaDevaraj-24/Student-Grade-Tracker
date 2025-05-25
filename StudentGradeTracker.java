import java.util.*;

class Student {
    String name;
    ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        return Collections.max(grades);
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        return Collections.min(grades);
    }

    public void displayStats() {
        System.out.println("\nStudent: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest : " + getLowest());
    }
}

public class StudentGradeTracker {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Student Grade Tracker Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grades to Student");
            System.out.println("3. View Student Stats");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addGrades();
                case 3 -> viewStudentStats();
                case 4 -> listStudents();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added.");
    }

    static Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    static void addGrades() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter number of grades to add: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            student.addGrade(grade);
        }

        System.out.println("Grades added.");
    }

    static void viewStudentStats() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.displayStats();
    }

    static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added.");
            return;
        }
        System.out.println("📋 Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}
