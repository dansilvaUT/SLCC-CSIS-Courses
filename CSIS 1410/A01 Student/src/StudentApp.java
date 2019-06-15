import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        ArrayList<Student> students =new ArrayList<Student>();

        students.add(new Student("Harry", "Potter", "CS", 3.9));
        students.add(new Student("Ron", "Weasly", "BIO", 2.0));
        students.add(new Student("Harry", "Potter", "HIS", 4.0));

        int choice;
        do {
            showMenu();
            System.out.print("\nYour selection ?");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    addStudent(students);
                    break;
                case 2:
                    findStudent(students);
                    break;
                case 3:
                    deleteStudent(students);
                    break;
                case 4:
                    displayStudents(students);
                    break;
                case 5:
                    displayTotalNumberofStudents(students);
                    break;
                case 6:
                    System.out.println("Goodbye");
                default:
            }
        } while(choice != 6);

    }

    /**
     * addStudent
     */
    private static void addStudent(ArrayList<Student> student)
    {
        System.out.print("First Name: ");
        String firstName = scanner.next();

        System.out.print("Last Name: ");
        String lastName = scanner.next();
        System.out.print("Major: ");
        String major = scanner.next();
        System.out.print("GPA: ");
        double gpa = scanner.nextDouble();
        Student students = new Student(firstName, lastName, major, gpa);
        student.add(students);
        System.out.println("Student has been added");
    }

    /**
     * Finds a student based on sNumber provided by user
     *
     * @param student
     */
    private static void findStudent(ArrayList<Student> student)
    {
        System.out.print("Find a student with the sNumber S");
        int sNumber = scanner.nextInt();
        Student found = null;
        for(Student s : student)
        {
            if(s.getSNumber() == sNumber)
            {
                found = s;
            }
        }

        if(found != null)
        {
            System.out.println(found.toString());
        } else
        {
            System.out.print("Student not found");
        }
    }

    /**
     * Finds a student by sNumber and deletes from list
     *
     * @param student
     */
    private static void deleteStudent(ArrayList<Student> students)
    {
        System.out.println("Delete a Student using sNumber S");
        int sNumber = scanner.nextInt();
        Student deleteStudent = null;

        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getSNumber() == sNumber)
            {
                deleteStudent = students.get(i);
            }
        }
        if (deleteStudent != null)
        {
            System.out.println("Removed: " + deleteStudent.toString());
            students.remove(deleteStudent);
        } else
        {
            System.out.println("Student not found.");
        }
    }

    /**
     * Iterates through the student lists and prints out
     * the items.
     *
     * @param student
     */
    private static void displayStudents(ArrayList<Student> student)
    {
        for(int i = 0; i < student.size(); i++)
            System.out.println(student.get(i));
    }

    /**
     * Show number of students
     */
    private static void displayTotalNumberofStudents(ArrayList<Student> student)
    {
        System.out.println(student.size());

    }

    /**
     * Show menu selection
     */
    private static void showMenu()
    {
        System.out.println("1. Add Student");
        System.out.println("2. Find Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Display Total Number of Students");
        System.out.print("6. Exit");
    }
}
