package kiosk;

public class ShoppingCart {
    private String item;
    private int quantity;
    private int price;

    //constructor
    public ShoppingCart(String item, int quantity, int price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    //item getter,setter
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    //quantanty getter,setter
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //price getter,setter
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
