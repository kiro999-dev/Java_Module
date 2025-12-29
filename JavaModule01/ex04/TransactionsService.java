package ex04;

import java.util.UUID;

public class TransactionsService {
    private UsersList usersList;

    TransactionsService()
    {
        usersList = new UsersArrayList();
    }
    public void Add(User user)
    {
       usersList.addUser(user);
    }
    public long userBalance(int id)
    {
        return usersList.findUserById(id).getBalance();
    }
    public void performTransfer(int recipentID,int senderID ,long amount)
    {
        UUID id = UUID.randomUUID();
        User sender = usersList.findUserById(senderID) ;
        if(sender.getBalance() < Math.abs(amount))
        {
            throw new IllegalTransactionException("user does not have enough money");
        }
        User recipent = usersList.findUserById(recipentID);
        Transaction transactionDebit = new Transaction(recipent, sender, "Debit", amount, id);
        Transaction transactionCredit = new Transaction(recipent, sender, "Credit", amount, id);
        sender.getTransactions().Add(transactionDebit);
        recipent.getTransactions().Add(transactionCredit);
        sender.SetBalance(sender.getBalance() - amount);
        recipent.SetBalance(recipent.getBalance() + amount);
    }
    public Transaction[] getTransfer(int id)
    {
        User user = usersList.findUserById(id);
        return user.getTransactions().toArray();
    }
    public void removeUserTransfer(int userId,UUID transactionId)
    {
        User user = usersList.findUserById(userId);
        user.getTransactions().Remove(transactionId);
    }
    public Transaction[] checkTransactionValidity() {
        TransactionsList unpairedTransactions = new TransactionsLinkedList();
        
        int userCount = usersList.getNumberOfUsers();
        for (int i = 0; i < userCount; i++) {
            User user = usersList.findUserByIndex(i);
            Transaction[] userTransactions = user.getTransactions().toArray();
            
            for (Transaction transaction : userTransactions) {
                if (!isTransactionPaired(transaction, user)) {
                    unpairedTransactions.Add(transaction);
                }
            }
        }
        
        return unpairedTransactions.toArray();
    }
    
    private boolean isTransactionPaired(Transaction transaction, User currentUser) {
        UUID transactionId = transaction.getIdentifier();
        User otherUser;
        if (transaction.getTransaction().equals("Debit")) {
            otherUser = transaction.getRecipient();
        } else {

            otherUser = transaction.getSender();
        }
      
        Transaction[] otherTransactions = otherUser.getTransactions().toArray();
        
     
        for (Transaction otherTransaction : otherTransactions) {
            if (otherTransaction.getIdentifier().equals(transactionId)) {
                return true; 
            }
        }
        
        return false; 
    }
}
