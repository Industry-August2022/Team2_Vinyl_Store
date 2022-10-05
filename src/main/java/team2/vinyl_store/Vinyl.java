package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vinyl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vinylId;
	private int genreId;
	private int studioId;
	private int artistId;
	private String title;
	private String description;
	private String releaseDate;
	private int priceCents;
	private String coverArtUrl;
	private int runtime;
	private int stockQuantity;
	private int timesOrdered;
	private boolean isExplicit;
	private boolean isArchived;

	public Vinyl() {
	}

	public Vinyl(int vinylID, int genreID, int studioID, int artistID, String title, String description,
			String releaseDate, int priceCents, String coverArtURL, int runtime, int stockQuantity, int timesOrdered,
			boolean isExplicit, boolean isArchived) {
		super();
		this.vinylId = vinylID;
		this.genreId = genreID;
		this.studioId = studioID;
		this.artistId = artistID;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.priceCents = priceCents;
		this.coverArtUrl = coverArtURL;
		this.runtime = runtime;
		this.stockQuantity = stockQuantity;
		this.timesOrdered = timesOrdered;
		this.isExplicit = isExplicit;
		this.isArchived = isArchived;
	}

	public int getVinylID() {
		return vinylId;
	}

	public void setVinylID(int vinylID) {
		this.vinylId = vinylID;
	}

	public int getGenreID() {
		return genreId;
	}

	public void setGenreID(int genreID) {
		this.genreId = genreID;
	}

	public int getStudioID() {
		return studioId;
	}

	public void setStudioID(int studioID) {
		this.studioId = studioID;
	}

	public int getArtistID() {
		return artistId;
	}

	public void setArtistID(int artistID) {
		this.artistId = artistID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCoverArtURL() {
		return coverArtUrl;
	}

	public void setCoverArtURL(String coverArtURL) {
		this.coverArtUrl = coverArtURL;
	}

	public int getPriceCents() {
		return priceCents;
	}

	public void setPriceCents(int priceCents) {
		this.priceCents = priceCents;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getTimesOrdered() {
		return timesOrdered;
	}

	public void setTimesOrdered(int timesOrdered) {
		this.timesOrdered = timesOrdered;
	}

	public boolean isExplicit() {
		return isExplicit;
	}

	public void setExplicit(boolean isExplicit) {
		this.isExplicit = isExplicit;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	@Override
	public String toString() {
		return "Vinyl [vinylID=" + vinylId + ", genreID=" + genreId + ", studioID=" + studioId + ", artistID="
				+ artistId + ", name=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", coverArtURL=" + coverArtUrl + ", priceCents=" + priceCents + ", runtime=" + runtime
				+ ", stockQuantity=" + stockQuantity + ", timesOrdered=" + timesOrdered + ", isExplicit=" + isExplicit
				+ ", isArchived=" + isArchived + "]";
	}

}
