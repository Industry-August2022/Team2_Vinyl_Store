package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artistId;
	private String name;
	
	public Artist() {
		super();
	}

	public Artist(int artistId, String name) {
		this.artistId = artistId;
		this.name = name;
	}

	public int getArtistID() {
		return artistId;
	}

	public void setArtistID(int artistID) {
		this.artistId = artistID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [artistID=" + artistId + ", name=" + name + "]";
	}

}
