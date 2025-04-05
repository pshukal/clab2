public class AltVehicleService {
    IVehicleInspector inspector;

    public AltVehicleService(String viType) {
        // Use the factory to get the correct implementation
        this.inspector = VehicleFactory.getVehicleInspector(viType);
    }
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
