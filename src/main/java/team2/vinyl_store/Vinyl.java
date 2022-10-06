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
		super();
	}

	public Vinyl(int vinylId, int genreId, int studioId, int artistId, String title, String description,
			String releaseDate, int priceCents, String coverArtUrl, int runtime, int stockQuantity, int timesOrdered,
			boolean isExplicit, boolean isArchived) {
		super();
		this.vinylId = vinylId;
		this.genreId = genreId;
		this.studioId = studioId;
		this.artistId = artistId;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.priceCents = priceCents;
		this.coverArtUrl = coverArtUrl;
		this.runtime = runtime;
		this.stockQuantity = stockQuantity;
		this.timesOrdered = timesOrdered;
		this.isExplicit = isExplicit;
		this.isArchived = isArchived;
	}

	public int getVinylId() {
		return vinylId;
	}

	public void setVinylId(int vinylId) {
		this.vinylId = vinylId;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public int getStudioId() {
		return studioId;
	}

	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
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

	public String getCoverArtUrl() {
		return coverArtUrl;
	}

	public void setCoverArtUrl(String coverArtUrl) {
		this.coverArtUrl = coverArtUrl;
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
		return "Vinyl [vinylId=" + vinylId + ", genreId=" + genreId + ", studioId=" + studioId + ", artist`="
				+ artistId + ", name=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", coverArtUrl=" + coverArtUrl + ", priceCents=" + priceCents + ", runtime=" + runtime
				+ ", stockQuantity=" + stockQuantity + ", timesOrdered=" + timesOrdered + ", isExplicit=" + isExplicit
				+ ", isArchived=" + isArchived + "]";
	}

}
