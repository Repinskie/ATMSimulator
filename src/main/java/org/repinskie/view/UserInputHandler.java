
package org.repinskie.view;

import org.repinskie.service.Account;
import org.repinskie.service.AccountService;
import org.repinskie.service.User;
import org.repinskie.view.userInteractionInterface.ConsoleUserInterface;

import java.util.Scanner;


public class UserInputHandler {
    private Account account;
    private AccountService accountService;
    public UserInputHandler(AccountService accountService){
        this.accountService = accountService;
    }
    public User user;
    private  ConsoleUserInterface consoleUserInterface;
    public UserInputHandler(Account account) {
        this.account = account;

    }
    public void setConsoleUserInterface(ConsoleUserInterface consoleUserInterface){
        this.consoleUserInterface = consoleUserInterface;
    }
    public void handleUserInput(Scanner console){
        int commandNum = console.nextInt();
        switch (commandNum){
            case 1 :
                handleCheckBalance();
                break;
            case 2 :
               handleWithdraw();
                break;
            case 3 :
                /*handleTransfer();*/
                break;
            case 4 :
                handleDeposit();
            case 5 :
                handleChangePIN();
            default:
                System.out.println("Invalid command");
        }
    }
    public void createAccountFromInput(Scanner console) {
        String name = consoleUserInterface.readName(console);
        int age = consoleUserInterface.readAge(console);
        int PINCode = consoleUserInterface.readPINCode(console);
        Account account1 = new Account(name,age,PINCode);
        account1.accountCreate(name,age,PINCode);
    }
    public void handleSignInOption(Scanner console) {
        String username = consoleUserInterface.readUserNameForSignIn(console);
        int pinCode = consoleUserInterface.readPinCodeForSignIn(console);

    }
    public void handleCheckBalance(){
        accountService.checkBalance(account.getUsername(),account.getPinCode());

    }
    public void handleWithdraw(){
        accountService.withdraw(account.getUsername(),account.getPinCode(),account.getBalance());
    }
    /*public void handleTransfer() {
        accountService.transferFunds();
    }*/
    public void handleDeposit(){
        System.out.println("Enter how ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        accountService.deposit(account.getUsername(),account.getPinCode(),amount);
    }
    public void handleChangePIN(){
        accountService.changePinCode(account.getPinCode());

    }

}

