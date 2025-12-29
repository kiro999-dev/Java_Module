
package ex04;

public class User {
    private String Name;
    private  final int   Identifier;
    private long balance;
    private TransactionsList transactions;
    User(String Name, long balance) {
        transactions = new TransactionsLinkedList();
        this.Name = Name;
        if (balance < 0) {
            System.err.println("balance it cannot be negative");
            System.exit(-1);
        }
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        this.balance = balance;
    }

    public int getId() {
        return Identifier;
    }

    public long getBalance() {
        return balance;
    }

    public void SetBalance(long balance) {
        this.balance = balance;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public TransactionsList getTransactions() {
        return transactions;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + Identifier +
                ", name='" + Name + '\'' +
                ", balance=" + balance +
                '}';
    }
}