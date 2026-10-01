package CourseRegistrationJDBC;
import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {

    static final String URL =
            "jdbc:mysql://localhost:3306/CollegeDB";

    static final String USER = "root";

    static final String PASSWORD = "root"; // Change to your password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Database connection
            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

            // Get course code
            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();

            // SQL query
            String sql =
                    "SELECT * FROM CourseRegistration WHERE CourseCode = ?";

            // PreparedStatement
            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, courseCode);

            // Execute query
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\nRegistered Students:");

            // Process ResultSet
            while (rs.next()) {

                found = true;

                System.out.println(
                        "Student ID: " +
                                rs.getInt("StudentID")
                );

                System.out.println(
                        "Student Name: " +
                                rs.getString("StudentName")
                );

                System.out.println(
                        "Course Code: " +
                                rs.getString("CourseCode")
                );

                System.out.println(
                        "Course Name: " +
                                rs.getString("CourseName")
                );

                System.out.println(
                        "Semester: " +
                                rs.getInt("Semester")
                );

                System.out.println("----------------------");
            }

            // No student found
            if (!found) {
                System.out.println(
                        "No students registered for course " + courseCode
                );
            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }
}
