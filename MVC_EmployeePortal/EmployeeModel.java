package MVC_EmployeePortal;

public class EmployeeModel {

    private String username = "admin";
    private String password = "admin123";

    private String employeeId;
    private String employeeName;
    private String department;

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void addEmployee(String id, String name, String dept) {
        employeeId = id;
        employeeName = name;
        department = dept;
    }

    public String getEmployee() {
        return "Employee ID: " + employeeId +
                "\nEmployee Name: " + employeeName +
                "\nDepartment: " + department;
    }

    public boolean changePassword(String oldPass,
                                  String newPass,
                                  String confirmPass) {

        if (password.equals(oldPass) &&
                newPass.equals(confirmPass)) {

            password = newPass;
            return true;
        }

        return false;
    }
}
