package DOCTOR;
public class DOCTORQ7_2 {

    private int doctorId;
    private String name;
    private String specialize;
    private double Fee;
    public DOCTORQ7_2(int doctorId, String name, String specialize, double Fee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialize = specialize;
        this.Fee = Fee;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialize;
    }
    public double getConsultationFee() {
        return Fee;
    }
    public void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialize);
        System.out.println("Consultation Fee: Rs." + Fee);
    }
}
