package org.repinskie.dao.accountManagmentInterface;



public interface AccountDAO {
    double getBalance(String username);
    void depositBalance(String username,double amount);
    void withdrawBalance(String username, double amount);
    void transfer(String senderName,String recipientName,double amount);


}
