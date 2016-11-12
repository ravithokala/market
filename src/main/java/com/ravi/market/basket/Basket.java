package com.ravi.market.basket;


import com.ravi.market.items.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    public Map<Item, Integer> basketItems;


    public Basket() {
        basketItems = new HashMap<Item, Integer>();
    }

    public void addBasketItem(BasketItem basketItem) {
        int existingCount = getItemCount(basketItem.getItem());
        if (existingCount == 0) {
            basketItems.put(basketItem.getItem(), basketItem.getCount());
        } else {
            basketItems.put(basketItem.getItem(), existingCount + basketItem.getCount());
        }
    }

    public void removeBasketItem(BasketItem basketItem) {
        int existingCount = getItemCount(basketItem.getItem());
        if (existingCount == basketItem.getCount()) {
            basketItems.remove(basketItem.getItem());
        } else if (existingCount > basketItem.getCount()) {
            basketItems.put(basketItem.getItem(), existingCount - basketItem.getCount());
        } else {
            throw new IllegalArgumentException("Can't remove more than existing count " + existingCount);
        }
    }

    public Map<Item, Integer> getBasketItems() {
        return Collections.unmodifiableMap(basketItems);
    }

    public double getTotal() {
        double total = 0.0;
        for (Map.Entry<Item, Integer> entry : basketItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public String toString() {
        String result = "";
        for (Map.Entry<Item, Integer> entry : basketItems.entrySet()) {
            result += entry.getValue() + " x " + entry.getKey().getName() + "\t" + entry.getKey().getPrice() + "\n";
        }
        result += "total = " + getTotal();
        return result;
    }

    private int getItemCount(Item item) {
        Integer count = basketItems.get(item);
        return count == null ? 0 : count;
    }
}
