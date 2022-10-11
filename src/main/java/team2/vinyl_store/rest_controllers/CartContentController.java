package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.CartContent;
import team2.vinyl_store.services.CartContentService;

@RestController
public class CartContentController {

	private final CartContentService cartContentService;

	@Autowired
	public CartContentController(CartContentService cartContentService) {
		this.cartContentService = cartContentService;
	}

	@GetMapping(path = "/api/cart_content/{id}")
	public CartContent getById(@PathVariable int id) {
		return cartContentService.getCartContentByID(id);
	}

	@GetMapping(path = "/api/cart_content")
	public List<CartContent> getAll() {
		return cartContentService.getAllCartContent();
	}

	@PostMapping(path = "/api/cart_content")
	public CartContent postNew(@RequestBody CartContent newCartContent) {
		return cartContentService.insertCartContent(newCartContent);
	}

}
