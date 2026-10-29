public class VisaCard implements InterfacePayment{

    @Override
    public void payingThroughCard(int amount) {
        System.out.println("paid with VISA");
    }
}
