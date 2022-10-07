package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.OrderInfo;
import team2.vinyl_store.services.OrderInfoService;

@RestController
public class OrderInfoController {

	private final OrderInfoService orderInfoService;

	@Autowired
	public OrderInfoController(OrderInfoService orderInfoService) {
		this.orderInfoService = orderInfoService;
	}

	@GetMapping(path = "/api/order_info/{id}")
	public OrderInfo getById(@PathVariable int id) {
		return orderInfoService.getOrderInfoByID(id);
	}

	@GetMapping(path = "/api/order_info")
	public List<OrderInfo> getAll() {
		return orderInfoService.getAllOrderInfos();
	}

	@PostMapping(path = "/api/order_info")
	public OrderInfo postNew(@RequestBody OrderInfo newOrderInfo) {
		return orderInfoService.insertOrderInfo(newOrderInfo);
	}

}
