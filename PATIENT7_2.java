package PATIENT;
public class PATIENT7_2 {

    private int patientId;
    private String name;
    private String disease;
    private int age;
    public PATIENT7_2(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public String getDisease() {
        return disease;
    }
    public int getAge() {
        return age;
    }
    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
    }
}
