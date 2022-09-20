package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import team2.vinyl_store.Category;

class CategoryTests {

	@Test
	void testRemove() {
		Category category = new Category();
		category.addVinyl(1);
		category.removeVinyl(1);
		if (category.getVinyl().size() != 0)
			fail("Failed to remove");
	}

}
