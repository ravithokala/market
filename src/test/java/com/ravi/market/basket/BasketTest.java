package com.ravi.market.basket;

import com.ravi.market.items.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BasketTest {

    private Basket basket = new Basket();

    @Test
    public void testAdNewdBasketItem() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 54));

        int onePoundAppleCount = basket.getBasketItems().get(onePoundApple);
        assertEquals(54, onePoundAppleCount);
    }

    @Test
    public void testAddExistingBasketItem() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 54));
        basket.addBasketItem(new BasketItem(onePoundApple, 46));

        int onePoundAppleCount = basket.getBasketItems().get(onePoundApple);
        assertEquals(100, onePoundAppleCount);
    }

    @Test
    public void testAddDifferentBasketItem() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        Orange twoPoundsOrange = new Orange(2.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 54));
        basket.addBasketItem(new BasketItem(twoPoundsOrange, 46));

        int onePoundAppleCount = basket.getBasketItems().get(onePoundApple);
        int twoPoundsOrangeCount = basket.getBasketItems().get(twoPoundsOrange);
        assertEquals(54, onePoundAppleCount);
        assertEquals(46, twoPoundsOrangeCount);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemFromEmptyBasket() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.removeBasketItem(new BasketItem(onePoundApple, 54));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMoreBasketItemsThanTheOneThatContainInBasket() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 1));
        basket.removeBasketItem(new BasketItem(onePoundApple, 2));
    }

    @Test
    public void testBasketItemShouldBeSameNumberOfItemsAreRemovedAsInBasket() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 5));
        basket.removeBasketItem(new BasketItem(onePoundApple, 5));

        assertNull(basket.getBasketItems().get(onePoundApple));
    }


    @Test
    public void testBasketItemShouldBeReducedByRemovedCount() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 7));
        basket.removeBasketItem(new BasketItem(onePoundApple, 2));

        int onePoundAppleCount = basket.getBasketItems().get(onePoundApple);
        assertEquals(5, onePoundAppleCount);

    }


    @Test
    public void testEmptyBasketItemsTotal() throws Exception {
        assertEquals(0.0, basket.getTotal(), 0.0);
    }


    @Test
    public void testOneBasketItemsTotal() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 5));
        assertEquals(5.0, basket.getTotal(), 0.0);
    }


    @Test
    public void testBasketItemsTotal() throws Exception {
        Apple onePoundApple = new Apple(1.0);
        Orange twoPoundsOrange = new Orange(2.0);
        Lemon threePoundsLemon = new Lemon(3.0);
        Banana fourPoundsBanana = new Banana(4.0);
        Peach fivePoundsPeach = new Peach(5.0);
        basket.addBasketItem(new BasketItem(onePoundApple, 1));
        basket.addBasketItem(new BasketItem(twoPoundsOrange, 2));
        basket.addBasketItem(new BasketItem(threePoundsLemon, 3));
        basket.addBasketItem(new BasketItem(fourPoundsBanana, 4));
        basket.addBasketItem(new BasketItem(fivePoundsPeach, 5));

        assertEquals(55.0, basket.getTotal(), 0.0);
    }

}