package com.ravi.market.basket;


import com.ravi.market.items.Item;

public class BasketItem {

    private final Item item;
    private final int count;

    public BasketItem(Item item, int count) {
        if (count < 1) {
            throw new IllegalArgumentException("item count must be at least 1");
        }
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
}
