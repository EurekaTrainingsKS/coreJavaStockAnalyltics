package eurekaAccounts;

import java.math.BigDecimal;

public abstract class Accounts {//class signature
    //access modifier can be only, public or proctcted
    // A bank account
    private String accountNumber;
    private BigDecimal accountBal;

    public Accounts(String accountNumber, BigDecimal accountBal) {
        this.accountNumber = accountNumber;
        this.accountBal = accountBal;
    }

//    public Accounts() {
//    }

    //for printing accountDetails
    public abstract void printAccountDetails();

    //method for credit
    public BigDecimal credit(BigDecimal creditAmount){// method signature
        setAccountBal(accountBal.add(creditAmount));
        return accountBal;
    }

    //method for debit
    public BigDecimal debit(BigDecimal debitedAmount){
        setAccountBal(accountBal.subtract(debitedAmount));//purchasing
        return accountBal;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBal() {
        return accountBal;
    }

    public void setAccountBal(BigDecimal accountBal) {
        this.accountBal = accountBal;
    }
}
