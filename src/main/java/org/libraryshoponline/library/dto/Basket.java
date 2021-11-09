package org.libraryshoponline.library.dto;

import java.util.List;

public class Basket {
    private List<Book> basket;
    private float amount;

    public List<Book> getBasket() {
        return basket;
    }

    public void setBasket(List<Book> basket) {
        this.basket = basket;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
