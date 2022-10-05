package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Category;
import team2.vinyl_store.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	protected CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category getCategoryByID(int id) {
		return categoryRepository.findById(id).get();
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category insertCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
