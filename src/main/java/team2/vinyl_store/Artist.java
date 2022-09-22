package team2.vinyl_store;

public class Artist {

	private int artistID;
	private String name;

	public Artist(int artistID, String name) {
		this.artistID = artistID;
		this.name = name;
	}

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [artistID=" + artistID + ", name=" + name + "]";
	}

}
