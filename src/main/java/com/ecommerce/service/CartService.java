package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CartResponse;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;

@Service
public class CartService {
	@Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // ✅ ADD YOUR METHOD HERE
    public List<CartResponse> getCartItems() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartResponse> response = new ArrayList<>();

        for (Cart cart : cartList) {
            Product product = productRepository
                .findById(cart.getProductId())
                .orElse(null);

            if (product != null) {
                CartResponse dto = new CartResponse();
                dto.setId(cart.getId());
                dto.setProductId(cart.getProductId());
                dto.setQuantity(cart.getQuantity());
                dto.setName(product.getName());
                dto.setPrice(product.getPrice());
                dto.setImage_url(product.getImage_url());

                response.add(dto);
            }
        }

        return response;
    }

}
