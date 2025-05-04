// LAB 4 TASK 3 – ONLINE COURSE MANAGEMENT SYSTEM

// COURSE CLASS
class Course {
    private String courseName;
    private String courseID;
    protected int credits;

    // Constructor 1 – Only courseName and courseID
    Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.credits = 0;
    }

    // Constructor 2 – courseName, courseID, and credits
    Course(String courseName, String courseID, int credits) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.credits = credits;
    }

    // Getters (for access in subclass)
    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    // Method to get course details
    public String getDetails() {
        return "Course Name: " + courseName + ", Course ID: " + courseID;
    }
}

// INSTRUCTOR CLASS
class Instructor extends Course {
    private String instructorName;
    protected String department;
    private Course associatedCourse;

    // Constructor 1 – Only instructor name and department
    Instructor(String instructorName, String department) {
        super("N/A", "N/A");  // Call base constructor with dummy data
        this.instructorName = instructorName;
        this.department = department;
        this.associatedCourse = null;
    }

    // Constructor 2 – Full: name, dept, and associated course
    Instructor(String instructorName, String department, Course course) {
        super(course.getCourseName(), course.getCourseID(), course.credits); // Inherit course info
        this.instructorName = instructorName;
        this.department = department;
        this.associatedCourse = course;
    }

    // Override getDetails()
    @Override
    public String getDetails() {
        String courseInfo = (associatedCourse != null) ?
            associatedCourse.getDetails() + ", Credits: " + associatedCourse.credits :
            "No course assigned";
        return "Instructor: " + instructorName + ", Department: " + department + "\n" + courseInfo;
    }
}

// MAIN CLASS
public class lab4Task3 {
    public static void main(String[] args) {
        // Create courses
        Course c1 = new Course("Object Oriented Programming", "CS201");
        Course c2 = new Course("Data Structures", "CS202", 4);

        // Create instructors
        Instructor i1 = new Instructor("Dr. Amna", "Computer Science");
        Instructor i2 = new Instructor("Sir Usman", "Computer Science", c2);

        // Display course and instructor details
        System.out.println(c1.getDetails());
        System.out.println(c2.getDetails());
        System.out.println();

        System.out.println(i1.getDetails());
        System.out.println();
        System.out.println(i2.getDetails());
    }
}
