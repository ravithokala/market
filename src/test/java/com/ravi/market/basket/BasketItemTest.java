package com.ravi.market.basket;

import com.ravi.market.items.Item;
import org.junit.Test;

public class BasketItemTest {


    @Test(expected = IllegalArgumentException.class)
    public void basketItemCountShouldBeAtLeastOne() {
        new BasketItem(new Item("TEST_ITEM", 9.80), -1);
    }

}