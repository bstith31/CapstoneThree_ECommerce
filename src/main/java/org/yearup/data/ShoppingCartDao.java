package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    // add additional method signatures here
    void addItemToCart(int userId, int productId);
    void updateCartItemQuantity(int userId, ShoppingCartItem item);
    void removeAllCartItems(int userId);

}
