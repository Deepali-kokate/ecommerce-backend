package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.Cart;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.service.CartService;
import com.ecommerce.dto.CartResponse;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins="http://localhost:3000")
public class CartController {
     
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    // Add to cart
    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    // ✅ UPDATED
    @GetMapping
    public List<CartResponse> getAllCart() {
        return cartService.getCartItems();
    }

    // (Optional improvement later)
    @GetMapping("/{userId}")
    public List<CartResponse> getCart(@PathVariable Long userId) {
        return cartService.getCartItems();
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return "Item removed";
    }
    @PutMapping("/{id}")
    public Cart updateQuantity(@PathVariable Long id, @RequestBody Cart updatedCart) {
        Cart cart = cartRepository.findById(id).orElse(null);

        if (cart != null) {
            cart.setQuantity(updatedCart.getQuantity());
            return cartRepository.save(cart);
        }

        return null;
    }
    
}