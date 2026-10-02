package WEEK8;

import javax.swing.*;
import java.awt.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, regField;
    JRadioButton male, female;
    JComboBox<String> department;
    JButton submit;

    public StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel("Gender:"));

        JPanel genderPanel = new JPanel();

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        add(new JLabel("Department:"));

        String[] departments = {
                "CSE",
                "ECE",
                "EEE",
                "Mechanical"
        };

        department = new JComboBox<>(departments);
        add(department);

        submit = new JButton("Submit");
        add(submit);

        submit.addActionListener(e -> {

            String name = nameField.getText();
            String reg = regField.getText();

            String gender;

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else
                gender = "Not Selected";

            String dept = (String) department.getSelectedItem();

            JOptionPane.showMessageDialog(
                    this,
                    "Name: " + name +
                            "\nRegister Number: " + reg +
                            "\nGender: " + gender +
                            "\nDepartment: " + dept
            );
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}