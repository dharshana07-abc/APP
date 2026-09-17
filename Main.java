import DOCTOR.DOCTORQ7_2;
import PATIENT.PATIENT7_2;
public class Main {
    public static void main(String[] args) {
        DOCTORQ7_2 d1 = new DOCTORQ7_2(101, "Dr. Ravi",
                "Cardiologist", 500);

        DOCTORQ7_2 d2 = new DOCTORQ7_2(102, "Dr. Priya",
                "Dermatologist", 300);
        PATIENT7_2 p1 = new PATIENT7_2(201, "Arun",
                "Heart Disease", 45);

        PATIENT7_2 p2 = new PATIENT7_2(202, "Meena",
                "Skin Allergy", 25);

        PATIENT7_2 p3 = new PATIENT7_2(203, "Kumar",
                "Heart Disease", 50);
        DOCTORQ7_2[] assignedDoctors = {d1, d2, d1};
        PATIENT7_2[] patients = {p1, p2, p3};
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < patients.length; i++) {
            System.out.println("\n-- Patient " + (i + 1) + " --");
            patients[i].displayPatient();
            System.out.println("\nTreating Doctor:");
            assignedDoctors[i].displayDoctor();

            if (assignedDoctors[i] == d1) {
                count1++;
            } else if (assignedDoctors[i] == d2) {
                count2++;
            }
        }
        double total1 = count1 * d1.getConsultationFee();
        double total2 = count2 * d2.getConsultationFee();
        System.out.println("\nTotal Consultation Fees:");
        System.out.println(d1.getName() + " - " +
                count1 + " patients: Rs." + total1);
        System.out.println(d2.getName() + " - " +
                count2 + " patients: Rs." + total2);
    }
}