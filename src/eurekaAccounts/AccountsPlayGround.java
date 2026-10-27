package eurekaAccounts;

import java.math.BigDecimal;

public class AccountsPlayGround {
    public static void main(String[] args) {
        CheckingAccount account1C = new CheckingAccount("1234",new BigDecimal(120));
        SavingsAccount account1S = new SavingsAccount("1235",new BigDecimal(220));
        Accounts accounts1 = new Accounts("1236",new BigDecimal(330)) {
            @Override
            public void printAccountDetails() {
                System.out.println("Account Number:" +getAccountNumber()+"\n"+
                        "Account Bal" +getAccountBal());
            }
        };

        //for checking
        account1C.printAccountDetails();
        account1C.debit(new BigDecimal(20));
        account1C.printAccountDetails();

        //for savings
        account1S.printAccountDetails();
        account1S.credit(new BigDecimal(50));
        account1S.printAccountDetails();

        //for simple sccount
        accounts1.debit(new BigDecimal(10));
        accounts1.credit(new BigDecimal(20));
        accounts1.printAccountDetails();

    }
}
