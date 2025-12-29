package ex04;

import java.util.UUID;



public interface TransactionsList {
    public void Add(Transaction data);
    public void Remove(UUID id);
    public Transaction[] toArray();
}
