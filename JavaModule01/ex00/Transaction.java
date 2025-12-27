package ex00;

import java.util.UUID;

public class Transaction {

   private User Recipient;
   private User Sender;
   private UUID Identifier;
   private long amount;
   private String transaction;

   Transaction(User Recipient, User Sender, String transaction, long amount) {

      this.Recipient = Recipient;
      this.Sender = Sender;
      if (transaction.equals("Debit")) {

         this.amount = -Math.abs(amount);

      } else if (transaction.equals("Credit")) {
         this.amount = Math.abs(amount);
      } else {
         System.err.println("Unknown transaction");
         System.exit(-1);
      }
      this.transaction = transaction;
      this.Identifier = UUID.randomUUID();
   }

   public UUID getIdentifier() {
      return Identifier;
   }

   public User getRecipient() {
      return Recipient;
   }

   public User getSender() {
      return Sender;
   }

   public long getAmount() {
      return amount;
   }

   public String getTransaction() {
      return transaction;
   }

   @Override
   public String toString() {
      return "Transaction{" +
            "id=" + Identifier +
            ", sender=" + Sender.getName() + "(id=" + Sender.getId() + ")" +
            ", recipient=" + Recipient.getName() + "(id=" + Recipient.getId() + ")" +
            ", category='" + transaction + '\'' +
            ", amount=" + amount +
            '}';
   }
}
