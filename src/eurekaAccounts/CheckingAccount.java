package eurekaAccounts;

import java.math.BigDecimal;

public class CheckingAccount extends Accounts{

    private static BigDecimal cashback = new BigDecimal(2.0);

    public CheckingAccount(String accountNumber, BigDecimal accountBal) {
        super(accountNumber, accountBal);
        //this refers to current
        //super refers to parent
    }

    @Override
    public BigDecimal debit(BigDecimal debitedAmount) {
        BigDecimal temp = debitedAmount.multiply(cashback).divide(new BigDecimal(100));
        System.out.println("The cashBack amount would be : "+temp);
        setAccountBal(getAccountBal().subtract(debitedAmount).add(temp));
        //setting account balanace on getter with substrarctig used amount and adding cash back
        return super.debit(debitedAmount);
    }

    @Override
    public void printAccountDetails() {
        System.out.println("Account Number :"+getAccountNumber()+"\n"
                            +"Account Bal :"+ getAccountBal()+"\n"
               + "Cashback amount :"+cashback+"%");
    }
}
