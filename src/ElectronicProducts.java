public class ElectronicProducts extends Product {

    protected int warrantyMonth;
    protected String model;

    public ElectronicProducts(String id, String name, double weightKg, double volumeCubicMeters,
                              double price, int currentStock, Category category, Status status, int warrantyMonth, String model) {
        super(id, name, weightKg, volumeCubicMeters, price, currentStock, category, status);
        this.warrantyMonth = warrantyMonth;
        this.model = model;
    }

    @Override
    public boolean matches(String query) {
        if (status.toString().equals(query)) return true;
        try {
            return Integer.parseInt(query) > price;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ElectronicProducts{" +
                "warrantyMonth=" + warrantyMonth +
                ", model='" + model + '\'' +
                '}';
    }

    public void setWarrantyMonth(int warrantyMonth) {
        this.warrantyMonth = warrantyMonth;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWarrantyMonth() {
        return warrantyMonth;
    }

    public String getModel() {
        return model;
    }
}
