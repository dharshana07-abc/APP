package MVC_EmployeePortal;

import javax.swing.*;

public class EmployeeController {

    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {

        this.model = model;
        this.view = view;

        // LOGIN
        view.loginButton.addActionListener(e -> {

            String username = view.usernameField.getText();
            String password =
                    new String(view.passwordField.getPassword());

            if (model.login(username, password)) {

                JOptionPane.showMessageDialog(
                        view, "Login Successful"
                );

                view.showMainWindow();

            } else {

                JOptionPane.showMessageDialog(
                        view, "Invalid Username or Password"
                );
            }
        });

        // ADD EMPLOYEE
        view.addEmployee.addActionListener(e -> {

            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                    "Employee ID:", id,
                    "Employee Name:", name,
                    "Department:", dept
            };

            int result = JOptionPane.showConfirmDialog(
                    view,
                    fields,
                    "Add Employee",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                model.addEmployee(
                        id.getText(),
                        name.getText(),
                        dept.getText()
                );

                JOptionPane.showMessageDialog(
                        view, "Employee Added Successfully"
                );
            }
        });

        // VIEW EMPLOYEE
        view.viewEmployee.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    view,
                    model.getEmployee()
            );
        });

        // CHANGE PASSWORD
        view.changePassword.addActionListener(e -> {

            JPasswordField oldPass = new JPasswordField();
            JPasswordField newPass = new JPasswordField();
            JPasswordField confirmPass = new JPasswordField();

            Object[] fields = {
                    "Old Password:", oldPass,
                    "New Password:", newPass,
                    "Confirm Password:", confirmPass
            };

            int result = JOptionPane.showConfirmDialog(
                    view,
                    fields,
                    "Change Password",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                boolean changed = model.changePassword(
                        new String(oldPass.getPassword()),
                        new String(newPass.getPassword()),
                        new String(confirmPass.getPassword())
                );

                if (changed) {
                    JOptionPane.showMessageDialog(
                            view,
                            "Password Changed Successfully"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            view,
                            "Old Password is incorrect or passwords do not match"
                    );
                }
            }
        });

        // LOGOUT
        view.logout.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    view, "Logged Out Successfully"
            );

            view.dispose();

            EmployeeView newView = new EmployeeView();

            new EmployeeController(model, newView);
        });

        // EXIT
        view.exit.addActionListener(e -> System.exit(0));
    }
}
