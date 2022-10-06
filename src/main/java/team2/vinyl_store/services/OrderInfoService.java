package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.OrderInfo;
import team2.vinyl_store.repositories.OrderInfoRepository;

@Service
public class OrderInfoService {

	private final OrderInfoRepository orderInfoRepository;

	@Autowired
	protected OrderInfoService(OrderInfoRepository orderInfoRepository) {
		this.orderInfoRepository = orderInfoRepository;
	}

	public OrderInfo getOrderInfoByID(int id) {
		return orderInfoRepository.findById(id).get();
	}
	
	public OrderInfo updateOrderInfo(OrderInfo orderInfo) {
		return orderInfoRepository.save(orderInfo);
	}
	
	public OrderInfo insertOrderInfo(OrderInfo orderInfo) {
		return orderInfoRepository.save(orderInfo);
	}

	public List<OrderInfo> getAllOrderInfos() {
		return orderInfoRepository.findAll();
	}

}
