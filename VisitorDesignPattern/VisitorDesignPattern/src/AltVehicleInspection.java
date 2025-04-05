public class AltVehicleInspection implements IVehicleInspector {
    @Override
    public int visit(Car car) {
        int serviceCharge = 0;
        if(car.getColor()=="Black"){
            serviceCharge += 200;
        }else{
            serviceCharge += 60;
        }
        System.out.println("Service Charge for Car: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Van van) {
        int serviceCharge = 0;
        if(van.getNumberOfDoors()>4){
            serviceCharge += 400;
        }else{
            serviceCharge += 120;
        }
        System.out.println("Service Charge for Van: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Motorbike motorbike) {
        int serviceCharge = 0;
        if(motorbike.getEngineCapacity()>=200){
            serviceCharge += 150;
        }else{
            serviceCharge += 35;
        }
        System.out.println("Service Charge for Motorbike: " + serviceCharge);
        return serviceCharge;
    }
}
