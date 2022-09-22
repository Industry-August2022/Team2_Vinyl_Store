package team2.vinyl_store;

public class Vinyl {

	private int vinylID;

	private int genreID;
	private int studioID;
	private int artistID;

	private String name;
	private String description;
	private String releaseDate;
	private String coverArtURL;
	private int priceCents;
	private int runtime;
	private int stockQuantity;
	private int timesOrdered;

	private boolean isExplicit;
	private boolean isArchived;

	public int getVinylID() {
		return vinylID;
	}

	public void setVinylID(int vinylID) {
		this.vinylID = vinylID;
	}

	public int getGenreID() {
		return genreID;
	}

	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	public int getStudioID() {
		return studioID;
	}

	public void setStudioID(int studioID) {
		this.studioID = studioID;
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
		return coverArtURL;
	}

	public void setCoverArtURL(String coverArtURL) {
		this.coverArtURL = coverArtURL;
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
		return "Vinyl [vinylID=" + vinylID + ", genreID=" + genreID + ", studioID=" + studioID + ", artistID="
				+ artistID + ", name=" + name + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", coverArtURL=" + coverArtURL + ", priceCents=" + priceCents + ", runtime=" + runtime
				+ ", stockQuantity=" + stockQuantity + ", timesOrdered=" + timesOrdered + ", isExplicit=" + isExplicit
				+ ", isArchived=" + isArchived + "]";
	}

}
