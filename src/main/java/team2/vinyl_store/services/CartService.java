package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Cart;
import team2.vinyl_store.repositories.CartRepository;

@Service
public class CartService {

	private final CartRepository cartRepository;

	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	public Cart getCartByID(int id) {
		return cartRepository.findById(id).get();
	}
	
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Cart insertCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	public Cart getCartByCustomerId(int customerId) {
		return cartRepository.getCartByCustomerId(customerId);
	}
	
	
}
