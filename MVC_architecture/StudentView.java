package MVC_architecture;
import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {

    JTextField nameField = new JTextField(15);
    JTextField mark1Field = new JTextField(15);
    JTextField mark2Field = new JTextField(15);
    JTextField mark3Field = new JTextField(15);

    JButton calculateButton = new JButton("Calculate Result");

    JLabel resultLabel = new JLabel("Result will appear here");

    public StudentView() {

        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Student Name:"));
        add(nameField);

        add(new JLabel("Subject 1 Marks:"));
        add(mark1Field);
        add(new JLabel("Subject 2 Marks:"));
        add(mark2Field);
        add(new JLabel("Subject 3 Marks:"));
        add(mark3Field);
        add(calculateButton);
        add(new JLabel(""));
        add(new JLabel("Result:"));
        add(resultLabel);
        setVisible(true);
    }
}
