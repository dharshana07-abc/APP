package MVC_VehicleService;

import java.awt.event.*;

public class VehicleController {

    private VehicleModel model;
    private VehicleView view;

    public VehicleController(VehicleModel model, VehicleView view) {

        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String regNo = view.regField.getText();

                String type =
                        (String) view.vehicleType.getSelectedItem();

                boolean general = view.generalBox.isSelected();
                boolean oil = view.oilBox.isSelected();
                boolean brake = view.brakeBox.isSelected();
                boolean battery = view.batteryBox.isSelected();

                model.calculateCost(
                        regNo, type,
                        general, oil, brake, battery
                );

                view.resultLabel.setText(
                        "Total Service Cost: Rs." + model.getTotalCost()
                );
            }
        });
    }
}
