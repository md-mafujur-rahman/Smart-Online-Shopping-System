public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity!");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " +
                price + " | Qty: " + quantity);
    }
}