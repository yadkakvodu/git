public class Product extends BaseEntity implements Searchable {

    protected double weightKg;
    protected double volumeCubicMeters;
    protected double price;
    protected int currentStock;
    protected Category category;
    public Status status;

    public Product(String id, String name, double weightKg, double volumeCubicMeters, double price, int currentStock, Category category, Status status) {
        super(id, name);
        this.weightKg = weightKg;
        this.volumeCubicMeters = volumeCubicMeters;
        this.price = price;
        this.currentStock = currentStock;
        this.category = category;
        this.status = status;
    }

    @Override
    public boolean matches(String query) {
        if (status.toString().equals(query)) return true;
        try {
            return Integer.parseInt(query) < price;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public enum Category {
        ELECTRONIC, NONELECTRONIC;
    }

    public enum Status {
        DOSTUPEN, NEDOSTUPEN;
    }

    public double getTotalVolume() {
        return volumeCubicMeters * currentStock;
    }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "weightKg=" + weightKg +
                ", volumeCubicMeters=" + volumeCubicMeters +
                ", price=" + price +
                ", currentStock=" + currentStock +
                ", category=" + category +
                ", status=" + status +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
