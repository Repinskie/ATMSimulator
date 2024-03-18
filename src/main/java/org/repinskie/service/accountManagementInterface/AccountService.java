package org.repinskie.service.accountManagementInterface;
import org.repinskie.service.Account;
import java.util.Map;
import java.util.Scanner;
public class AccountService implements  AccountManager{
    private static Scanner scanner = new Scanner(System.in);
    private Account account;
    public AccountService(Account account){
        this.account = account;
    }
    private Map<String,Account> accountMap;
    @Override
    public double checkBalance() {
        return account.getBalance();
    }
    @Override
    public void deposit(double amount) {
        account.setBalance(amount);
    }
    @Override
    public void withdraw() {

    }
    @Override
    public void transferFunds() {

    }
    public void changePinCode(int pinCode){
        account.setPinCode(pinCode);
    }
    /*@Override
    public void transferFunds(String senderUser, int senderPin, String receiverUserName, double amount) {

    }*/
}
