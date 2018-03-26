package data.collector.parking.spaces;

public class MadisonResponse {
	
	private String name;
	
	private String id;
	
	//Free parking spaces
	private int vacant_stalls;

	public String getName() {
		return name;
	}

	public String getId() {
		return City.Madison.getId()+"_"+id;
	}

	public int getVacant_stalls() {
		return vacant_stalls;
	}
	

}
