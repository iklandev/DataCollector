package data.collector.parking.spaces;

import java.math.BigDecimal;

public class AnnArborResponse {

	private String name;
	
	private int freeSpaces;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private String address;
	
	public AnnArborResponse(String name, int freeSpaces, BigDecimal latitude, BigDecimal longitude, String address) {
		this.name = name;
		this.freeSpaces = freeSpaces;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getFreeSpaces() {
		return freeSpaces;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public String getAddress() {
		return address;
	}
	
	public String getId(){
		
		String inId="";
		if (name.equals("Fourth & Washington Structure")){
			inId="1";
		} else if (name.equals("First & Washington Structure")) {
			inId="2";
		} else if (name.equals("Maynard Structure")) {
			inId="3";
		} else if (name.equals("Forest Structure")) {
			inId="4";
		} else if (name.equals("Fourth & William Structure")) {
			inId="5";
		} else if (name.equals("Liberty Square Structure")) {
			inId="6";
		} else if (name.equals("Ann Ashley Structure")) {
			inId="7";
		} else if (name.equals("Library Lane Structure")) {
			inId="8";
		} else if (name.equals("South Ashley Lot")) {
			inId="9";
		} else if (name.equals("First & Huron Lot")) {
			inId="10";
		} else  {
			return "";
		}
		return City.AnnArbor.getId()+"_"+name.substring(0,2).toUpperCase()+inId;
	}
	
}
