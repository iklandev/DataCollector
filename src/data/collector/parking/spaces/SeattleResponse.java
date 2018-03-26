package data.collector.parking.spaces;

public class SeattleResponse {

	private String Id;
	
	private String Timestamp;
	
	private int VacantSpaces;
	
	private String GarageName;
	
	// If it return "CLOSE" then garage is closed,
	// this field can be use as indicator if the garage is available
	private String DisplayText;
	
	private String Neighborhood;
	
	private String StreetAddress;

	public String getId() {
		return City.Seattle.getId()+"_"+Id;
	}

	public String getTimestamp() {
		return Timestamp;
	}

	public int getVacantSpaces() {
		return VacantSpaces;
	}

	public String getGarageName() {
		return GarageName;
	}

	public String getDisplayText() {
		return DisplayText;
	}

	public String getNeighborhood() {
		return Neighborhood;
	}

	public String getStreetAddress() {
		return StreetAddress;
	}
	
}
