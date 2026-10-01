package MVC_architecture;
import java.awt.event.*;

public class StudentController {

    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {

        this.model = model;
        this.view = view;
        view.calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = view.nameField.getText();
                int m1 = Integer.parseInt(view.mark1Field.getText());
                int m2 = Integer.parseInt(view.mark2Field.getText());
                int m3 = Integer.parseInt(view.mark3Field.getText());
                model.calculate(name, m1, m2, m3);
                view.resultLabel.setText(
                        "<html>Name: " + model.getName() +
                                "<br>Total: " + model.getTotal() +
                                "<br>Average: " + String.format("%.2f", model.getAverage()) +
                                "<br>Grade: " + model.getGrade() +
                                "</html>"
                );
            }
        });
    }
}