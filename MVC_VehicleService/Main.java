package MVC_VehicleService;

public class Main {

    public static void main(String[] args) {

        VehicleModel model = new VehicleModel();

        VehicleView view = new VehicleView();

        new VehicleController(model, view);
    }
}
