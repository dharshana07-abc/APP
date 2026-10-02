package WEEK8;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class CourseManagement extends JFrame {
    JTextField studentName;
    JList<String> courseList;
    JTable table;
    DefaultTableModel model;
    JButton addButton;
    JButton removeButton;
    public CourseManagement() {
        setTitle("Student Course Management");
        setSize(600, 450);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Student Name:"));
        studentName = new JTextField(15);
        add(studentName);
        String[] courses = {"Java",
                "Python",
                "Data Structures",
                "Operating Systems",
                "Database Management"
        };
        courseList = new JList<>(courses);
        JScrollPane courseScroll = new JScrollPane(courseList);
        courseScroll.setPreferredSize(new Dimension(180, 100));
        add(courseScroll);
        String[] columns = {"Student Name", "Course", "Status"
        };
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(550, 200));
        add(tableScroll);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        add(addButton);
        add(removeButton);
        addButton.addActionListener(e -> {
            String name = studentName.getText();
            String course = courseList.getSelectedValue();
            if (!name.isEmpty() && course != null) {
                model.addRow(new Object[]{name, course, "Enrolled"
                });
            } else {
                JOptionPane.showMessageDialog(this, "Enter student name and select a course."
                );
            }
        });
        removeButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to remove."
                );
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new CourseManagement();
    }
}
