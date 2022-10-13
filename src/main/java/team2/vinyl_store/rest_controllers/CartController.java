package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Cart;
import team2.vinyl_store.services.CartService;

@RestController
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping(path = "/api/cart/{id}")
	public Cart getById(@PathVariable int id) {
		return cartService.getCartByID(id);
	}

	@GetMapping(path = "/api/cart")
	public List<Cart> getAll() {
		return cartService.getAllCarts();
	}

	@PostMapping(path = "/api/cart")
	public Cart postNew(@RequestBody Cart newCart) {
		return cartService.insertCart(newCart);
	}

	@GetMapping(path = "/api/cart/user/{id}")
	public Cart getByUserId(@PathVariable int id) {
		Cart cart = cartService.getCartByCustomerId(id);
		if(cart == null) {
			cart = cartService.insertCart(new Cart(0,id,null));
		}
		return cart;
	}

}
