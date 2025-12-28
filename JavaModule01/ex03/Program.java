package ex03;

public class Program {
    public static void main(String[] args) {

        User alice = new User("Alice", 1000);
        User bob = new User("Bob", 500);
        User charlie = new User("Charlie", 750);

        TransactionsLinkedList transactions = new TransactionsLinkedList();

        Transaction t1 = new Transaction(bob, alice, "Debit", 100);
        Transaction t2 = new Transaction(charlie, alice, "Credit", 200);
        Transaction t3 = new Transaction(alice, bob, "Debit", 50);
        transactions.Add(t1);
        transactions.Add(t2);
        transactions.Add(t3);
        transactions.printReverse();

    }
}