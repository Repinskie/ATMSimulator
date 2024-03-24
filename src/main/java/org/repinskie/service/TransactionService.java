package org.repinskie.service;

import org.repinskie.dao.transactionManagmentInterface.TransactionDAOImpl;

public class TransactionService {
    private TransactionDAOImpl transactionDAOImpl;
    /*public TransactionService(TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }
    public void performTransaction(int senderAccountId, int receiverAccountId, double amount){
        Transaction transaction = new Transaction();
        transaction.setSenderAccountId(senderAccountId);
        transaction.setReceiverAccountId(receiverAccountId);
        transaction.setAmount(amount);
        transaction.setTimestamp(new Date());
        transactionDAO.saveTransaction(transaction);
    }*/
}
