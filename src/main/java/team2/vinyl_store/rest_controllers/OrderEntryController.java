package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.OrderEntry;
import team2.vinyl_store.services.OrderEntryService;

@RestController
public class OrderEntryController {

	private final OrderEntryService orderEntryService;

	@Autowired
	public OrderEntryController(OrderEntryService orderEntryService) {
		this.orderEntryService = orderEntryService;
	}

	@GetMapping(path = "/api/order_entry/{id}")
	public OrderEntry getById(@PathVariable int id) {
		return orderEntryService.getOrderEntryByID(id);
	}

	@GetMapping(path = "/api/order_entry")
	public List<OrderEntry> getAll() {
		return orderEntryService.getAllOrderEntries();
	}

	@PostMapping(path = "/api/order_entry")
	public OrderEntry postNew(@RequestBody OrderEntry newOrderEntry) {
		return orderEntryService.insertOrderEntry(newOrderEntry);
	}

}
