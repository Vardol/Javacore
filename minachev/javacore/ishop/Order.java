package ru.minachev.javacore.ishop;

public class Order {
    private Customer customer;
    private Item item;
    private int amount;

    public Order(Customer customer, Item item, int amount) {
        this.customer = customer;
        this.item = item;
        this.amount = amount;
    }
}
