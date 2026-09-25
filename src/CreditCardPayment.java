public class CreditCardPayment extends Payment {

    public void pay(double amount) {
        System.out.println(
                "Paid " + amount + " by Credit Card."
        );
    }
}