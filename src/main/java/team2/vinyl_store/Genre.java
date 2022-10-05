package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genreId;
	private String name;

	public Genre() {
		super();
	}

	public Genre(int genreId, String name) {
		super();
		this.genreId = genreId;
		this.name = name;
	}

	public int getGenreID() {
		return genreId;
	}

	public void setGenreID(int genreID) {
		this.genreId = genreID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [genreID=" + genreId + ", name=" + name + "]";
	}

}
