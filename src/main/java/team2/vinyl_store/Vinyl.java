package team2.vinyl_store;

public class Vinyl {
	
	private int vinylID;
	private int genreID;
	private int studioID;
	private int artistID;
	private String title;
	private String description;
	private String releaseDate;
	private int priceCents;
	private String coverArtURL;
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
		this.vinylID = vinylID;
		this.genreID = genreID;
		this.studioID = studioID;
		this.artistID = artistID;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.priceCents = priceCents;
		this.coverArtURL = coverArtURL;
		this.runtime = runtime;
		this.stockQuantity = stockQuantity;
		this.timesOrdered = timesOrdered;
		this.isExplicit = isExplicit;
		this.isArchived = isArchived;
	}


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
				+ artistID + ", name=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", coverArtURL=" + coverArtURL + ", priceCents=" + priceCents + ", runtime=" + runtime
				+ ", stockQuantity=" + stockQuantity + ", timesOrdered=" + timesOrdered + ", isExplicit=" + isExplicit
				+ ", isArchived=" + isArchived + "]";
	}

}
