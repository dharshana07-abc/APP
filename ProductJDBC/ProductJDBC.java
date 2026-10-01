package ProductJDBC;
import java.sql.*;
import java.util.Scanner;

public class ProductJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/StoreDB";
    static final String USER = "root";
    static final String PASSWORD = "root"; // Change to your MySQL password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");

            while (true) {

                System.out.println("\n--- PRODUCT MENU ---");
                System.out.println("1. Insert Product");
                System.out.println("2. Search Product");
                System.out.println("3. Update Quantity");
                System.out.println("4. Display Products with Quantity < 10");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    // INSERT PRODUCT
                    case 1:

                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();

                        String insert =
                                "INSERT INTO Product VALUES (?, ?, ?, ?)";

                        PreparedStatement ps =
                                con.prepareStatement(insert);

                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setDouble(3, price);
                        ps.setInt(4, quantity);

                        ps.executeUpdate();

                        System.out.println("Product Inserted Successfully");
                        break;


                    // SEARCH PRODUCT
                    case 2:

                        System.out.print("Enter Product ID: ");
                        int searchId = sc.nextInt();

                        String search =
                                "SELECT * FROM Product WHERE ProductID=?";

                        ps = con.prepareStatement(search);
                        ps.setInt(1, searchId);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {

                            System.out.println(
                                    "Product ID: " +
                                            rs.getInt("ProductID"));

                            System.out.println(
                                    "Product Name: " +
                                            rs.getString("ProductName"));

                            System.out.println(
                                    "Price: " +
                                            rs.getDouble("Price"));

                            System.out.println(
                                    "Quantity: " +
                                            rs.getInt("Quantity"));

                        } else {
                            System.out.println("Product Not Found");
                        }

                        break;


                    // UPDATE QUANTITY
                    case 3:

                        System.out.print("Enter Product ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Quantity: ");
                        int newQuantity = sc.nextInt();

                        String update =
                                "UPDATE Product SET Quantity=? WHERE ProductID=?";

                        ps = con.prepareStatement(update);

                        ps.setInt(1, newQuantity);
                        ps.setInt(2, updateId);

                        int rows = ps.executeUpdate();

                        if (rows > 0)
                            System.out.println(
                                    "Quantity Updated Successfully");
                        else
                            System.out.println("Product Not Found");

                        break;


                    // DISPLAY QUANTITY BELOW 10
                    case 4:

                        String display =
                                "SELECT * FROM Product WHERE Quantity < 10";

                        ps = con.prepareStatement(display);

                        rs = ps.executeQuery();

                        System.out.println("\nLow Stock Products:");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("ProductID") + " | " +
                                            rs.getString("ProductName") + " | " +
                                            rs.getDouble("Price") + " | " +
                                            rs.getInt("Quantity")
                            );
                        }

                        break;


                    // EXIT
                    case 5:

                        con.close();
                        sc.close();

                        System.out.println("Program Closed");
                        return;


                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }
}
