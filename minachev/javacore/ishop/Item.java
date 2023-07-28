package ru.minachev.javacore.ishop;

public class Item {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(String name, int price) {
        if (name.equals("")){
            name = "n/a";
        }



        this.name = name;
        if (price <= 0){
            price = 1;
        }
        this.price = price;
    }
}
