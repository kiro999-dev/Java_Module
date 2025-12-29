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
    public void Performingtransfer(int recipentID,int senderID ,long amount)
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
        sender.getTransactions().Add(transactionCredit);
        recipent.getTransactions().Add(transactionDebit);

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
    // public Transaction[] transactions()
    // {

    // }
}
