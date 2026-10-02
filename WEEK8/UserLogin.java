package WEEK8;
import javax.swing.*;
import java.awt.*;
public class UserLogin extends JFrame {
    JTextField username;
    JPasswordField password;
    JCheckBox remember;
    JCheckBox notifications;
    JButton login;
    public UserLogin() {
        setTitle("User Login");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Username:"));
        username = new JTextField();
        add(username);
        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);
        remember = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");
        add(remember);
        add(notifications);
        login = new JButton("Login");
        add(login);
        login.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());
            if (!user.isEmpty() && !pass.isEmpty()) {
                String message = "Login Successful!" + "\nUsername: " + user + "\nRemember Me: " + remember.isSelected() + "\nNotifications: " + notifications.isSelected();
                JOptionPane.showMessageDialog(this, message);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter username and password."
                );
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new UserLogin();
    }
}
