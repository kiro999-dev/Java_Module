package ex04;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();

        System.out.println("=== Creating Users ===");
        User john = new User("John", 1000);
        User mike = new User("Mike", 500);
        
        service.Add(john);
        service.Add(mike);
        
        System.out.println("John balance: " + service.userBalance(john.getId()));
        System.out.println("Mike balance: " + service.userBalance(mike.getId()));

        System.out.println("\n=== Transfer: Mike sends 200 to John  ===");
        service.performTransfer(john.getId(), mike.getId(), 200);
        
        System.out.println("John balance: " + service.userBalance(john.getId()));
        System.out.println("Mike balance: " + service.userBalance(mike.getId()));

        System.out.println("\n=== John's Transactions ===");
        Transaction[] johnTx = service.getTransfer(john.getId());
        for (Transaction t : johnTx) {
            System.out.println(t);
        }

        System.out.println("\n=== Mike's Transactions ===");
        Transaction[] mikeTx = service.getTransfer(mike.getId());
        for (Transaction t : mikeTx) {
            System.out.println(t);
        }

        System.out.println("\n=== Check Validity (Should be valid) ===");
        Transaction[] unpaired = service.checkTransactionValidity();
        System.out.println("Unpaired transactions: " + unpaired.length);

        System.out.println("\n=== Remove John's Transaction ===");
        UUID txId = johnTx[0].getIdentifier();
        System.out.println("Removing: " + txId);
        service.removeUserTransfer(john.getId(), txId);

        System.out.println("\n=== Check Validity (Should find 1 unpaired) ===");
        unpaired = service.checkTransactionValidity();
        System.out.println("Unpaired transactions: " + unpaired.length);
        if (unpaired.length > 0) {
            System.out.println("Unpaired transaction:");
            System.out.println(unpaired[0]);
        }

        System.out.println("\n=== Test Insufficient Balance ===");
        try {
            service.performTransfer(mike.getId(), john.getId(), 10000);
        } catch (IllegalTransactionException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}