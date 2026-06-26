
public class Main {
    public static void main(String[] args) {
        WarehouseManagementSystem wrh = new WarehouseManagementSystem();

        WareHouse wr1 = new WareHouse("123", "sss", "Moscow", 1500.0, 150.0, WareHouse.Status.SVOBODEN);
        WareHouse wr2 = new WareHouse("321", "ddd", "St-Petersburg", 2000.0, 190.0, WareHouse.Status.ZANYAT);

        Shipment sh1 = new Shipment("555", "Breads", "Surgut", "26-09-2018", "26-12-2018", Shipment.Status.NEOTGRUJEN);
        Shipment sh2 = new Shipment("777", "Breads", "Kaliningrad", "26-09-2018", "26-12-2018", Shipment.Status.NEOTGRUJEN);


        Product pr1 = new Product("321", "IPhone", 150, 150.0, 30, 90, Product.Category.ELECTRONIC, Product.Status.DOSTUPEN);
        Product pr2 = new Product("1723", "IPad", 150, 150.0, 30, 90, Product.Category.ELECTRONIC, Product.Status.NEDOSTUPEN);

        System.out.println("Добавление двух товаров: ");
        System.out.println();
        System.out.println(wrh.addProduct((pr1)));
        System.out.println(wrh.addProduct((pr2)));

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Добавление груза на склад: ");
        System.out.println(wr1.getStoredItems());
        System.out.println(wrh.recieveStock(pr1, 15, wr1));
        System.out.println(wr1.getStoredItems());


        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Добавление двух складов через ПО управления складом: ");
        System.out.println(wrh.addWarehouse(wr1));
        System.out.println(wrh.addWarehouse(wr2));

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Добавление двух грузов через ПО управления складом: ");

        System.out.println(wrh.addShipment(sh1));
        System.out.println(wrh.addShipment(sh2));

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Поиск по грузу для 1 варианта: ");
        System.out.println("1) " + "Поиск по ID: " + wrh.searchShipments("777"));
        System.out.println("2) " + "Поиск по статусу груза: " + wrh.searchShipments("NEOTGRUJEN"));

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Поиск товаров по статусу и цене > N: ");
        System.out.println("1) " + wrh.searchProducts("20"));
        System.out.println("2) " + wrh.searchProducts("DOSTUPEN"));


        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("Изменение статуса груза: ");
        System.out.println(sh1.status);
        System.out.println(wrh.updateShipmentStatus("Отгружен", sh1));
        System.out.println(sh1.status);



    }
}