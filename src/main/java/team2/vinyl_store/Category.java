package team2.vinyl_store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "category_entry", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "vinyl_id"))
	private List<Vinyl> vinyl;

	public Category() {
		super();
		this.vinyl = new ArrayList<>();
	}

	public Category(int categoryID, String name) {
		this.categoryId = categoryID;
		this.name = name;
		this.vinyl = new ArrayList<>();
	}

	public Category(int categoryID, String name, List<Vinyl> vinyl) {
		this.categoryId = categoryID;
		this.name = name;
		this.vinyl = vinyl;
	}

	public int getCategoryID() {
		return categoryId;
	}

	public void setCategoryID(int categoryID) {
		this.categoryId = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vinyl> getVinyl() {
		return vinyl;
	}

	public void addVinyl(Vinyl vinyl) {
		this.vinyl.add(vinyl);
	}

	public boolean removeVinyl(Vinyl vinyl) {
		return this.vinyl.remove(vinyl);
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryId + ", name=" + name + ", vinyl=" + vinyl + "]";
	}

}
