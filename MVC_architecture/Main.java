package MVC_architecture;

public class main {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        new StudentController(model, view);
    }
}
