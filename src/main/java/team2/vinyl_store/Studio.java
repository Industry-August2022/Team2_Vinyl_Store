package team2.vinyl_store;

public class Studio {
	
	private int studioID;
	private String name;

	public Studio() {
	}

	public Studio(int studioID, String name) {
		super();
		this.studioID = studioID;
		this.name = name;
	}

	public int getStudioID() {
		return studioID;
	}

	public void setStudioID(int studioID) {
		this.studioID = studioID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Studio [studioID=" + studioID + ", name=" + name + "]";
	}

}
