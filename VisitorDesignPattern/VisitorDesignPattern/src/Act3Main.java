import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Act3Main {
    public static void main(String[] args) {
        List<IVehicle> vehicles = new ArrayList<>();
        String filePath = System.getProperty("data");

        if (filePath == null) {
            System.out.println("Please specify JSON file path using -Ddata");
            return;
        }

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(reader);

            for (Object obj : jsonArray) {
                JSONObject vehicleObj = (JSONObject) obj;
                String vtype = (String) vehicleObj.get("vtype");

                switch (vtype.trim()) {
                    case "Car":
                        String color = (String) vehicleObj.get("color");
                        String myear = (String) vehicleObj.get("myear");
                        vehicles.add(new Car(color, Integer.parseInt(myear)));
                        break;
                    case "Van":
                        String storage = (String) vehicleObj.get("storage");
                        String doors = (String) vehicleObj.get("numdoors");
                        vehicles.add(new Van(Integer.parseInt(storage), Integer.parseInt(doors)));
                        break;
                    case "Motorbike":
                        String engine = (String) vehicleObj.get("engine");
                        String brand = (String) vehicleObj.get("brand");
                        vehicles.add(new Motorbike(Integer.parseInt(engine), brand));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        IVehicle[] vehicleArray = vehicles.toArray(new IVehicle[0]);
        int total = Act3VehicleService.getInstance().calculateTotal(vehicleArray);
        System.out.println("Total service charge (with emissions): $" + total);
    }
}
