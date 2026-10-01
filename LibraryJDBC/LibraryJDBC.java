package LibraryJDBC.java;
import java.sql.*;
import java.util.Scanner;

public class LibraryJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    static final String USER = "root";
    static final String PASSWORD = "root"; // Change to your MySQL password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

            while (true) {

                System.out.println("\n--- LIBRARY MENU ---");
                System.out.println("1. Insert New Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    // INSERT BOOK
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        String insert =
                                "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";

                        PreparedStatement ps =
                                con.prepareStatement(insert);

                        ps.setInt(1, id);
                        ps.setString(2, title);
                        ps.setString(3, author);
                        ps.setDouble(4, price);
                        ps.setBoolean(5, true);

                        ps.executeUpdate();

                        System.out.println("Book Inserted Successfully");
                        break;


                    // SEARCH BOOK
                    case 2:
                        System.out.print("Enter Book ID: ");
                        int searchId = sc.nextInt();

                        String search =
                                "SELECT * FROM Book WHERE BookID=?";

                        ps = con.prepareStatement(search);
                        ps.setInt(1, searchId);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("Book ID: " +
                                    rs.getInt("BookID"));

                            System.out.println("Title: " +
                                    rs.getString("Title"));

                            System.out.println("Author: " +
                                    rs.getString("Author"));

                            System.out.println("Price: " +
                                    rs.getDouble("Price"));

                            System.out.println("Available: " +
                                    rs.getBoolean("Availability"));
                        } else {
                            System.out.println("Book Not Found");
                        }

                        break;


                    // DISPLAY AVAILABLE BOOKS
                    case 3:
                        String display =
                                "SELECT * FROM Book WHERE Availability=true";

                        Statement stmt = con.createStatement();

                        rs = stmt.executeQuery(display);

                        System.out.println("\nAvailable Books:");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("BookID") + " | " +
                                            rs.getString("Title") + " | " +
                                            rs.getString("Author") + " | " +
                                            rs.getDouble("Price")
                            );
                        }

                        break;


                    // ISSUE BOOK
                    case 4:
                        System.out.print("Enter Book ID to issue: ");
                        int issueId = sc.nextInt();

                        String update =
                                "UPDATE Book SET Availability=false WHERE BookID=?";

                        ps = con.prepareStatement(update);
                        ps.setInt(1, issueId);

                        int rows = ps.executeUpdate();

                        if (rows > 0)
                            System.out.println("Book Issued Successfully");
                        else
                            System.out.println("Book Not Found");

                        break;


                    // EXIT
                    case 5:
                        con.close();
                        System.out.println("Program Closed");
                        return;

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
