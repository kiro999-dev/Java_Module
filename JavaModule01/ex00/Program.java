package ex00;

public class Program {
    public static void main(String[] args) {
        // Create users
        User john = new User("John", 1000);
        User mike = new User("Mike", 500);

        System.out.println("=== Initial Users ===");
        System.out.println(john);
        System.out.println(mike);

        System.out.println("\n=== Creating Transactions ===");
        
        // John sends 200 to Mike - Create Debit for John (sender)
        Transaction debitTx = new Transaction(mike, john, "Debit", 200);
        System.out.println(debitTx);

        // John sends 200 to Mike - Create Credit for Mike (recipient)
        Transaction creditTx = new Transaction(mike, john, "Credit", 200);
        System.out.println(creditTx);

        System.out.println("\n=== User Details ===");
        System.out.println("John: " + john.getName() + ", Balance: " + john.getBalance());
        System.out.println("Mike: " + mike.getName() + ", Balance: " + mike.getBalance());
        
        System.out.println("\n=== Transaction Details ===");
        System.out.println("Debit Transaction ID: " + debitTx.getIdentifier());
        System.out.println("Credit Transaction ID: " + creditTx.getIdentifier());
    }
}