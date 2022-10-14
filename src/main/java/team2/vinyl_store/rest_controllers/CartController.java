package team2.vinyl_store.rest_controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Cart;
import team2.vinyl_store.CartContent;
import team2.vinyl_store.OrderEntry;
import team2.vinyl_store.OrderInfo;
import team2.vinyl_store.services.CartContentService;
import team2.vinyl_store.services.CartService;
import team2.vinyl_store.services.OrderEntryService;
import team2.vinyl_store.services.OrderInfoService;

@RestController
public class CartController {

	private final CartService cartService;
	private final CartContentService cartContentService;
	private final OrderInfoService orderInfoService;
	private final OrderEntryService orderEntryService;

	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public CartController(CartService cartService, CartContentService cartContentService,
			OrderInfoService orderInfoService, OrderEntryService orderEntryService) {
		this.cartService = cartService;
		this.cartContentService = cartContentService;
		this.orderInfoService = orderInfoService;
		this.orderEntryService = orderEntryService;
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
		if (cart == null) {
			cart = cartService.insertCart(new Cart(0, id, null));
		}
		return cart;
	}

	@GetMapping(path = "/api/cart/checkout/{userId}")
	public OrderInfo checkoutUser(@PathVariable int userId) {
		Cart cart = cartService.getCartByCustomerId(userId);
		if (cart == null)
			return new OrderInfo(0, 0, "1000-01-01", null);
		OrderInfo order = orderInfoService
				.insertOrderInfo(new OrderInfo(0, userId, DATE_FORMAT.format(new Date()), null));
		for (CartContent content : cart.getCartContents()) {
			orderEntryService.insertOrderEntry(
					new OrderEntry(0, order.getOrderInfoId(), content.getVinylId(), content.getQuantity()));
			cartContentService.deleteCartContent(content.getCartContentId());
		}
		cartService.deleteCart(cart.getCartId());
		return order;
	}

}
