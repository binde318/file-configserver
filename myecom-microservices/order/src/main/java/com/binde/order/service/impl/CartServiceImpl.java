package com.binde.order.service.impl;

import com.binde.order.dto.CartItemRequest;
import com.binde.order.model.CartItem;
import com.binde.order.repository.CartItemRepository;
import com.binde.order.service.CartService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartItemRepository cartItemRepository;


    @Override
    public boolean addToCart(String userId, CartItemRequest request) {
        userId = userId.replace("\"", "");
        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(userId, request.getProductId());

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
            cartItem.setPrice(BigDecimal.valueOf(1000.00)); // Or fetch from product
            cartItemRepository.save(cartItem);
        } else {
            CartItem newCartItem = new CartItem();
            newCartItem.setProductId(request.getProductId());
            newCartItem.setUserId(userId);
            newCartItem.setQuantity(request.getQuantity());
            newCartItem.setPrice(BigDecimal.valueOf(1000.00)); // Or fetch from product
            cartItemRepository.save(newCartItem);
        }

        return true;
    }
    @Override
    public boolean deleteFromCart(String userId, String productId) {
        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(userId,productId);
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
            return true;
        }

        return false;
    }

    @Override
    public List<CartItem> getCart(String userId) {
        return cartItemRepository.findByUserId(userId);

    }

    @Override
    public void clearCart(String userId) {
        cartItemRepository.findByUserId(userId);
    }
}
