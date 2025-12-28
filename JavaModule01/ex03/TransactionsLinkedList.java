package ex03;

import java.util.UUID;

import ex00.Transaction;

public class TransactionsLinkedList implements TransactionsList {
    private class Node {
        private Transaction transaction;
        private Node Next;
        private Node Prv;

        Node(Transaction transaction) {
            this.transaction = transaction;
            Next = null;
            Prv = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public void Add(Transaction data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.Next = null;
            head.Prv = null;
        } else {
            tail.Next = newNode;
            newNode.Prv = tail;
            tail = newNode;
            tail.Next = null;
        }
        size++;
    }

    @Override
    public void Remove(UUID id) {
        if (head == null) {
            throw new TransactionNotFoundException("Transaction Not Found");
        }
        if (head.transaction.getIdentifier().equals(id)) {
            head = head.Next;
            if (head != null) {
                head.Prv = null;
            } else {
                tail = null;
            }
            size--;
            return;
        }
        Node current = head;
        while (current.Next != null) {
            if (current.Next.transaction.getIdentifier().equals(id)) {
                Node nodeToRemove = current.Next;
                current.Next = nodeToRemove.Next;
                if (nodeToRemove.Next != null) {
                    nodeToRemove.Next.Prv = current;
                } else {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.Next;
        }
        throw new TransactionNotFoundException("Transaction Not Found");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] array = new Transaction[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index] = current.transaction;
            current = current.Next;
            index++;
        }
        return array;
    }
    public void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.transaction);
            current = current.Prv;
        }
    }
}
