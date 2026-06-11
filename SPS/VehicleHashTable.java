import java.util.HashMap;
import java.util.Map;

public class VehicleHashTable {
    private Map<String,Vehicle>plateMap;

    private Map<Integer,String>slotMap;

    public VehicleHashTable(){
        plateMap = new HashMap<>();
        slotMap = new HashMap<>();
    }

    public void addMapping(Vehicle vehicle){
        plateMap.put(vehicle.getPlateNum(),vehicle);
        slotMap.put(vehicle.getSlotId(),vehicle.getPlateNum());
    }

    public Vehicle getVehicleByPlate(String plate){
        return plateMap.get(plate);
    }

    public String getPlarteBySlot(int slotId){
        return slotMap.get(slotId);
    }

    public void removeMapping(int slotId,String plate){
        plateMap.remove(plate);
        slotMap.remove(slotId);
    }

    public boolean isSlotOccupide(int slotId){
        return slotMap.containsKey(slotId);
    }
}
