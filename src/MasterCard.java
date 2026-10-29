public class MasterCard implements InterfacePayment {
    @Override
    public void payingThroughCard(int amount) {
        System.out.println("Paid through MasterCard");
    }
}
