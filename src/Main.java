import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Student ID: 251-35-533");
        System.out.println("Student Name: MD. Mafujur Rahman");

        Scanner sc = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product(
                101, "Laptop", 60000, 5);

        Product p2 = new Product(
                102, "Headphone", 2000, 10);

        Customer customer =
                new Customer(
                        1, "MD. Mafujur Rahman");

        Order order =
                new Order(1001, customer, cart);

        while (true) {

            System.out.println(
                    "\n===== Online Shopping System ====="
            );

            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Display Shopping Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Save Order");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println(
                        "Products are available."
                );
            }

            else if (choice == 2) {
                p1.display();
                p2.display();
            }

            else if (choice == 3) {

                System.out.print("Product ID: ");
                int id = sc.nextInt();

                if (id == 101)
                    cart.addProduct(p1);

                else if (id == 102)
                    cart.addProduct(p2);

                else
                    System.out.println(
                            "Product not found."
                    );
            }

            else if (choice == 4) {

                System.out.print("Product ID: ");
                cart.removeProduct(sc.nextInt());
            }

            else if (choice == 5) {
                cart.displayCart();
            }

            else if (choice == 6) {

                System.out.println("1. Credit Card");
                System.out.println("2. Mobile Banking");

                System.out.print("Payment: ");
                int type = sc.nextInt();

                if (type == 1)
                    order.checkout(
                            new CreditCardPayment());

                else
                    order.checkout(
                            new MobileBankingPayment());

                order.invoice();
            }

            else if (choice == 7) {

                System.out.println("1. Credit Card");
                System.out.println("2. Mobile Banking");

                System.out.print("Payment: ");
                int type = sc.nextInt();

                if (type == 1)
                    order.saveOrder("Credit Card");

                else
                    order.saveOrder("Mobile Banking");
            }

            else if (choice == 8) {

                System.out.println(
                        "Program ended."
                );
                break;
            }

            else {
                System.out.println(
                        "Invalid choice."
                );
            }
        }

        sc.close();
    }
}