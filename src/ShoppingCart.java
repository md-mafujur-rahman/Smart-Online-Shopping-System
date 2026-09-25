import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products =
            new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added.");
    }

    public void removeProduct(int id) {

        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("Product removed.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void displayCart() {

        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Product p : products)
            p.display();

        System.out.println("Total: " + getTotal());
    }

    public double getTotal() {

        double total = 0;

        for (Product p : products)
            total += p.getPrice();

        return total;
    }
}