import java.io.FileWriter;

public class Order implements Discountable {

    private int orderId;
    private Customer customer;
    private ShoppingCart cart;

    public Order(int orderId, Customer customer,
                 ShoppingCart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
    }

    public double getDiscount(double amount) {
        return amount * 0.10;
    }

    public void checkout(Payment payment) {

        double total = cart.getTotal();
        double discount = getDiscount(total);

        payment.pay(total - discount);

        System.out.println("Checkout completed.");
    }

    public void invoice() {

        double total = cart.getTotal();
        double discount = getDiscount(total);

        System.out.println("\n===== INVOICE =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " +
                customer.getName());
        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final: " +
                (total - discount));
    }

    public void saveOrder(String payment) {

        try {
            FileWriter f =
                    new FileWriter("orders.txt");

            f.write("Order ID: " + orderId + "\n");
            f.write("Customer: " +
                    customer.getName() + "\n");
            f.write("Total: " +
                    cart.getTotal() + "\n");
            f.write("Payment: " + payment + "\n");

            f.close();

            System.out.println("Order saved.");

        } catch (Exception e) {
            System.out.println("File error.");
        }
    }
}