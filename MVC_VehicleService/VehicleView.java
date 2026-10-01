package MVC_VehicleService;

import javax.swing.*;
import java.awt.*;

public class VehicleView extends JFrame {

    JTextField regField = new JTextField(15);

    JComboBox<String> vehicleType =
            new JComboBox<>(new String[]{"Two Wheeler", "Car"});

    JCheckBox generalBox = new JCheckBox("General Service - Rs.1000");
    JCheckBox oilBox = new JCheckBox("Oil Change - Rs.800");
    JCheckBox brakeBox = new JCheckBox("Brake Service - Rs.1200");
    JCheckBox batteryBox = new JCheckBox("Battery Check - Rs.500");

    JButton calculateButton = new JButton("Calculate Cost");

    JLabel resultLabel = new JLabel("Total Cost: ");

    public VehicleView() {

        setTitle("Vehicle Service Cost Estimator");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        add(new JLabel("Vehicle Registration Number:"));
        add(regField);

        add(new JLabel("Vehicle Type:"));
        add(vehicleType);

        add(generalBox);
        add(oilBox);
        add(brakeBox);
        add(batteryBox);

        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }
}
