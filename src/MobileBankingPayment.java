public class MobileBankingPayment extends Payment {

    public void pay(double amount) {
        System.out.println(
                "Paid " + amount + " by Mobile Banking."
        );
    }
}