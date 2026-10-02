package WEEK8;

class DeliveryTask extends Thread {
    String activity;

    DeliveryTask(String name, String activity) {
        setName(name);
        this.activity = activity;
    }

    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: " + activity);
    }
}

public class Online_Food_Delivery_Multithreading {

    public static void main(String[] args) {

        DeliveryTask t1 = new DeliveryTask(
                "OrderProcessing",
                "Processing customer orders"
        );

        DeliveryTask t2 = new DeliveryTask(
                "DeliveryTracking",
                "Tracking delivery location"
        );

        DeliveryTask t3 = new DeliveryTask(
                "Notification",
                "Sending order-status notifications"
        );

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
