import java.util.*;

public class Shipment extends BaseEntity implements Searchable {

    protected String destinationAddress;
    protected String dispatchDate;
    protected String expectedDate;
    protected Map<Product, Integer> itemsToShip;
    protected Status status;
    protected WareHouse sourceWareHouse;

    public Shipment(String id, String name, String destinationAddress, String dispatchDate,
                    String expectedDate, Status status) {
        super(id, name);
        this.destinationAddress = destinationAddress;
        this.dispatchDate = dispatchDate;
        this.expectedDate = expectedDate;
        this.itemsToShip = new HashMap<>();
        this.status = status;
    }

    @Override
    public boolean matches(String query) {
        return id.equalsIgnoreCase(query) || status.toString().equalsIgnoreCase(query);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "destinationAddress='" + destinationAddress + '\'' +
                ", dispatchDate='" + dispatchDate + '\'' +
                ", expectedDate='" + expectedDate + '\'' +
                ", itemsToShip=" + itemsToShip +
                ", status=" + status +
                ", sourceWareHouse=" + sourceWareHouse +
                '}';
    }

    @Override
    public String getDetails() {
        return toString();
    }

    public enum Status {
        OTGRUJEN, NEOTGRUJEN;
    }

    public double getTotalShipmentVolume() {
        List<Integer> nn = new ArrayList<>(itemsToShip.values());
        int c = 0;
        for (int i : nn) {
            c += i;
        }
        return c;
    }

    public double getTotalShipmentWeight() {
        List<Integer> nn = new ArrayList<>(itemsToShip.values());
        int c = 0;
        for (int i : nn) {
            c += i;
        }
        return c * 15;
    }



}
