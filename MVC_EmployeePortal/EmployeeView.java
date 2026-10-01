package MVC_EmployeePortal;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {

    JTextField usernameField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);
    JButton loginButton = new JButton("Login");

    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem viewEmployee = new JMenuItem("View Employee");
    JMenuItem changePassword = new JMenuItem("Change Password");
    JMenuItem logout = new JMenuItem("Logout");
    JMenuItem exit = new JMenuItem("Exit Application");

    public EmployeeView() {

        setTitle("Employee Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        add(usernameField);

        add(new JLabel("Password:"));
        add(passwordField);

        add(new JLabel(""));
        add(loginButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showMainWindow() {

        getContentPane().removeAll();

        setTitle("Employee Management Portal");
        setSize(500, 300);

        JMenuBar menuBar = new JMenuBar();

        JMenu employeeMenu = new JMenu("Employee");
        JMenu toolsMenu = new JMenu("Tools");
        JMenu exitMenu = new JMenu("Exit");

        employeeMenu.add(addEmployee);
        employeeMenu.add(viewEmployee);

        toolsMenu.add(changePassword);

        exitMenu.add(logout);
        exitMenu.add(exit);

        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);

        add(new JLabel(
                "Welcome to Employee Management Portal",
                SwingConstants.CENTER
        ));

        revalidate();
        repaint();
    }
}
