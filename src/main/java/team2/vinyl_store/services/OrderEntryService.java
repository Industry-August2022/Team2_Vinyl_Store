package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.OrderEntry;
import team2.vinyl_store.repositories.OrderEntryRepository;

@Service
public class OrderEntryService {

	private final OrderEntryRepository orderEntryRepository;

	@Autowired
	protected OrderEntryService(OrderEntryRepository orderEntryRepository) {
		this.orderEntryRepository = orderEntryRepository;
	}

	public OrderEntry getOrderEntryByID(int id) {
		return orderEntryRepository.findById(id).get();
	}
	
	public OrderEntry updateOrderEntry(OrderEntry orderEntry) {
		return orderEntryRepository.save(orderEntry);
	}
	
	public OrderEntry insertOrderEntry(OrderEntry orderEntry) {
		return orderEntryRepository.save(orderEntry);
	}

	public List<OrderEntry> getAllOrderEntries() {
		return orderEntryRepository.findAll();
	}

}
