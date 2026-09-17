package student;
    public class Student {
        int id;
        String name;
        String department;
        public Student(int id,String name,String department) {
            this.id=id;
            this.name=name;
            this.department=department;
        }
        public void displayStudent() {
            System.out.println("Student ID: "+id);
            System.out.println("Student Name: "+name);
            System.out.println("Department: "+department);
        }
    }
}
