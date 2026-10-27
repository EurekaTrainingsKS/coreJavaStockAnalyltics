package eurekaAccounts;

import java.math.BigDecimal;

public class SavingsAccount extends Accounts{
    public static BigDecimal APR = new BigDecimal(10.0);

    public SavingsAccount(String accountNumber, BigDecimal accountBal) {
        super(accountNumber, accountBal);
    }

    @Override
    public BigDecimal credit(BigDecimal creditAmount) {
        BigDecimal rate = creditAmount.multiply(APR.multiply(new BigDecimal(0.12)));
        System.out.println("APR amount is :"+rate);
        System.out.println("Amount needed to repay is :"+creditAmount.add(rate));
        setAccountBal(getAccountBal().add(creditAmount));
        return getAccountBal();
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Number :"+getAccountNumber()+"\n"
                +"Account Bal :"+getAccountBal()+"\n"
                +"APR :"+APR+"%");
    }
}
