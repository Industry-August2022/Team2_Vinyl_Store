package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Category;
import team2.vinyl_store.services.CategoryService;

@RestController
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping(path = "/api/category/{id}")
	public Category getById(@PathVariable int id) {
		return categoryService.getCategoryByID(id);
	}

	@GetMapping(path = "/api/category")
	public List<Category> getAll() {
		return categoryService.getAllCategories();
	}

	@PostMapping(path = "/api/category")
	public Category postNew(@RequestBody Category newCategory) {
		return categoryService.insertCategory(newCategory);
	}

}
