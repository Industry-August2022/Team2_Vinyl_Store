package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studioId;
	private String name;

	public Studio() {
	}

	public Studio(int studioId, String name) {
		super();
		this.studioId = studioId;
		this.name = name;
	}

	public int getStudioId() {
		return studioId;
	}

	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Studio [studioId=" + studioId + ", name=" + name + "]";
	}

}
