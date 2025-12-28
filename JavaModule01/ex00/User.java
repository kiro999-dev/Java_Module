
package ex00;

public class User {
    private String Name;
    private int Identifier;
    private long balance;
    private static int id = 1;

    User(String Name, long balance) {
        this.Name = Name;
        if (balance < 0) {
            System.err.println("balance it cannot be negative");
            System.exit(-1);
        }
        this.Identifier = id;
        this.balance = balance;
        id++;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + Identifier +
                ", name='" + Name + '\'' +
                ", balance=" + balance +
                '}';
    }
}