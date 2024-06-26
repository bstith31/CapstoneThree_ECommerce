package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    // add additional method signatures here
    ShoppingCart addItemToCart(int userId, int productId);
    void updateCartItemQuantity(int userId, int productId);
    void removeAllCartItems(int userId);

}
