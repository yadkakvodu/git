import java.util.*;

public class WarehouseManagementSystem {

    protected List<Product> products;
    protected List<WareHouse> warehouses;
    protected List<Shipment> shipments;

    public WarehouseManagementSystem() {
        this.products = new ArrayList<>();
        this.warehouses = new ArrayList<>();
        this.shipments = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        products.add(product);
        return true;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product product, int count) {
        int index = products.indexOf(product);
        if (index > 0) {
            products.set(index, product);
        }
    }

    public boolean addWarehouse(WareHouse wareHouse) {
        warehouses.add(wareHouse);
        return true;
    }

    public void removeWarehouse(WareHouse wareHouse) {
        warehouses.remove(wareHouse);
    }

    public boolean addShipment(Shipment shipment) {
        shipments.add(shipment);
        return true;
    }

    public void removeShipment(Shipment shipment) {
        shipments.remove(shipment);
    }

    public void updateShipment(Shipment shipment) {
        int index = shipments.indexOf(shipment);
        if (index > 0) {
            shipments.remove(shipment);
        }
    }

    public boolean updateShipmentStatus(String stat, Shipment shipment) {
        if (stat.equalsIgnoreCase("Отгружен")) {
            shipment.status = Shipment.Status.OTGRUJEN;
            return true;
        }
        if (stat.equalsIgnoreCase("Не отгружен")) {
            shipment.status = Shipment.Status.NEOTGRUJEN;
            return true;
        }
        return false;
    }

    public boolean recieveStock(Product product, int quantity, WareHouse wareHouse) {
        if (wareHouse.status == WareHouse.Status.SVOBODEN) {
            wareHouse.status = WareHouse.Status.ZANYAT;
            wareHouse.addProductStock(product, quantity);
            return true;
        }
        return false;
    }

    public List<Product> searchProducts(String query) {
        List<Product> pr = new ArrayList<>();
        for (Product p : products) {
            if (p.matches(query)) {
                pr.add(p);
            }
        }
        return pr;
    }

    public List<Shipment> searchShipments(String query) {
        List<Shipment> sh = new ArrayList<>();
        for (Shipment s : shipments) {
            if (s.matches(query)) {
                sh.add(s);
            }
        }
        return sh;
    }

    
}
