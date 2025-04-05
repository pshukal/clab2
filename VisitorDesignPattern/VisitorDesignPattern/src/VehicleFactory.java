public class VehicleFactory {
    private VehicleFactory() {}
    // private, to prevent instantiation
    public static IVehicleInspector getVehicleInspector(String prop) {
        if ("alt".equalsIgnoreCase(prop)) {
            return new AltVehicleInspection();
        }
        return new VehicleInspection(); // this will be the default fallback
    }
}
