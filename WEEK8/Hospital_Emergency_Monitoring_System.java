package WEEK8;
class EmergencyAlert extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Critical patient alert");
    }
}
class VitalMonitor extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Checking vital signs");
    }
}
class ReportGenerator extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Generating routine report");
    }
}
public class Hospital_Emergency_Monitoring_System {
    public static void main(String[] args) {
        EmergencyAlert t1 = new EmergencyAlert();
        VitalMonitor t2 = new VitalMonitor();
        ReportGenerator t3 = new ReportGenerator();
        t1.setName("EmergencyAlert");
        t2.setName("VitalMonitor");
        t3.setName("ReportGenerator");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
