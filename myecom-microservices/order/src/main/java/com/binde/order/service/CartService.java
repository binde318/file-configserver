package com.binde.order.service;



import com.binde.order.dto.CartItemRequest;
import com.binde.order.model.CartItem;

import java.util.List;

public interface CartService {
    boolean addToCart(String userId, CartItemRequest request);

    boolean deleteFromCart(String userId, String productId);

    List<CartItem> getCart(String userId);

    void clearCart(String userId);
}
