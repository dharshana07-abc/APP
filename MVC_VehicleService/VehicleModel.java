package MVC_VehicleService;

public class VehicleModel {

    private String regNo;
    private String vehicleType;
    private int totalCost;

    public void calculateCost(String regNo, String vehicleType,
                              boolean general, boolean oil,
                              boolean brake, boolean battery) {

        this.regNo = regNo;
        this.vehicleType = vehicleType;
        totalCost = 0;

        if (general)
            totalCost += 1000;

        if (oil)
            totalCost += 800;

        if (brake)
            totalCost += 1200;

        if (battery)
            totalCost += 500;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
