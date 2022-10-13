package team2.vinyl_store.search;

public class SearchVinylRequest {

	private String query;
	private int artistId;
	private int genreId;
	private int studioId;
	private String orderBy;

	public SearchVinylRequest() {
		super();
	}

	public SearchVinylRequest(String query, int artistId, int genreId, int studioId, String orderBy) {
		super();
		this.query = query;
		this.artistId = artistId;
		this.genreId = genreId;
		this.studioId = studioId;
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "SearchRequest [query=" + query + ", artistId=" + artistId + ", genreId=" + genreId + ", studioId="
				+ studioId + ", orderBy=" + orderBy + "]";
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}