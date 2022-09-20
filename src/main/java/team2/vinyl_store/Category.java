package team2.vinyl_store;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int categoryID;
	private String name;
	private List<Integer> vinyl;
	
	public Category() {
		vinyl = new ArrayList<>();
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getVinyl() {
		return vinyl;
	}

	public void addVinyl(int vinyl) {
		this.vinyl.add(vinyl);
	}

	public boolean removeVinyl(int vinyl) {
		return this.vinyl.remove((Integer) vinyl);
	}

}
