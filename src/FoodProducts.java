public class FoodProducts extends Product {

    protected String expiryDate;
    protected boolean isPerishable;

    public FoodProducts(String id, String name, double weightKg, double volumeCubicMeters, double price,
                        int currentStock, Category category, Status status, String expiryDate, boolean isPerishable) {
        super(id, name, weightKg, volumeCubicMeters, price, currentStock, category, status);
        this.expiryDate = expiryDate;
        this.isPerishable = isPerishable;
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
        return "FoodProducts{" +
                "expiryDate='" + expiryDate + '\'' +
                ", isPerishable=" + isPerishable +
                '}';
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }
}
