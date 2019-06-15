/**
 * Student class that creates a student object
 * @author danielsilva
 *
 */
public class Student {
    private String firstName;
    private String lastName;
    private int sNumber;
    private String major;
    private double gpa;
    private static int count = 1234567;

    public Student()
    {
        this.sNumber = count;
    }

    /**
     * Constructor constructs and initializes student object
     * @param fName Student first name
     * @param lName Student last name
     * @param maj   Student major
     * @param gpa	Student gpa
     */
    public Student(String fName,String lName,String maj, double gpa)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.major = maj;
        this.gpa = gpa;
        this.sNumber = count++;
    }

    /**
     *
     * @return String student first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     *
     * @param fName sets first name of student
     */
    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }

    /**
     *
     * @return String student last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     *
     * @param lName sets student last name
     */
    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    /**
     *
     * @return int student s number
     */
    public int getSNumber()
    {
        return sNumber;
    }

    /**
     *
     * @return String major
     */
    public String getMajor()
    {
        return major;
    }

    /**
     *
     * @param major set student major
     */
    public void setMajor(String major)
    {
        this.major = major;
    }

    /**
     *
     * @return double student gpa
     */
    public double getGpa()
    {
        return gpa;
    }

    /**
     *
     * @param gpa set student gpa
     */
    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    @Override
    public String toString()
    {
        return String.format("%d %s %s (%s) GPA: %.2f",
                getSNumber(), getFirstName(), getLastName(), getMajor(), getGpa());
    }
}