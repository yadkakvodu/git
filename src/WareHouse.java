import java.util.*;

public class WareHouse extends BaseEntity {

    protected String address;
    protected double totalCapacityCubicMeters;
    protected double currentOccupiedVolume;
    protected Status status;
    protected Map<Product, Integer> storedItems;

    public WareHouse(String id, String name, String address, double totalCapacityCubicMeters, double currentOccupiedVolume,
                     Status status) {
        super(id, name);
        this.address = address;
        this.totalCapacityCubicMeters = totalCapacityCubicMeters;
        this.currentOccupiedVolume = currentOccupiedVolume;
        this.status = status;
        this.storedItems = new HashMap<>();
    }

    public enum Status {
        SVOBODEN, ZANYAT;
    }

    public double getAvailableCapacity() {
        return totalCapacityCubicMeters - currentOccupiedVolume;
    }

    public boolean addProductStock(Product product, int count) {
        if (!storedItems.containsKey(product)) {
            storedItems.put(product, count);
            return true;
        }
        return false;
    }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "address='" + address + '\'' +
                ", totalCapacityCubicMeters=" + totalCapacityCubicMeters +
                ", currentOccupiedVolume=" + currentOccupiedVolume +
                ", status=" + status +
                ", storedItems=" + storedItems +
                '}';
    }

    public boolean removeProductStock(Product product, int count) {
        if (storedItems.containsKey(product)) {
            storedItems.remove(product);
            return true;
        }
        return false;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalCapacityCubicMeters(double totalCapacityCubicMeters) {
        this.totalCapacityCubicMeters = totalCapacityCubicMeters;
    }

    public void setCurrentOccupiedVolume(double currentOccupiedVolume) {
        this.currentOccupiedVolume = currentOccupiedVolume;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStoredItems(Map<Product, Integer> storedItems) {
        this.storedItems = storedItems;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalCapacityCubicMeters() {
        return totalCapacityCubicMeters;
    }

    public double getCurrentOccupiedVolume() {
        return currentOccupiedVolume;
    }

    public Status getStatus() {
        return status;
    }

    public Map<Product, Integer> getStoredItems() {
        return storedItems;
    }
}
