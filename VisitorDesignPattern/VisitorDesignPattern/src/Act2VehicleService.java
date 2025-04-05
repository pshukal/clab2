public class Act2VehicleService {
    private static final Act2VehicleService instance;
    private IVehicleInspector inspector;
    static {
        // Static block runs once
        String viType = System.getProperty("vi");
        IVehicleInspector insp = VehicleFactory.getVehicleInspector(viType);
        instance = new Act2VehicleService(insp);
    }
    private Act2VehicleService(IVehicleInspector inspector) {
        this.inspector = inspector;
    }
    public static Act2VehicleService getInstance() {
        return instance;
    }
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
