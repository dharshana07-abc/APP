class Student{
    String name;
    int rollno;
    String dept;
    Student(String n,int r,String d) 
  {
        name=n;
        rollno=r;
        dept=d;
    }
    void displayDetail() 
  {
        System.out.println("Name:"+name);
        System.out.println("Rollno:"+rollno);
        System.out.println("Dept:"+dept);
    }
}
public class Main{
    public static void main(String[] args) {
        Student s = new Student("Dharshana",101,"CSE");
        s.displayDetails();
    }
}
