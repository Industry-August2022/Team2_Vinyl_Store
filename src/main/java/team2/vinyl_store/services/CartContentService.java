package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.CartContent;
import team2.vinyl_store.repositories.CartContentRepository;

@Service
public class CartContentService {
	
	private final CartContentRepository cartContentRepository;

	@Autowired
	public CartContentService(CartContentRepository cartContentRepository) {
		this.cartContentRepository = cartContentRepository;
	}
	
	public CartContent getCartContentByID(int id) {
		return cartContentRepository.findById(id).get();
	}
	
	public CartContent updateCartContent(CartContent cartContent) {
		return cartContentRepository.save(cartContent);
	}
	
	public CartContent insertCartContent(CartContent cartContent) {
		return cartContentRepository.save(cartContent);
	}

	public List<CartContent> getAllCartContent() {
		return cartContentRepository.findAll();
	}
}
