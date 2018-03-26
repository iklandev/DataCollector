package data.collector.parking.spaces;

import java.math.BigDecimal;

public class SantaMonicaResponse {

	private int available_spaces;
	
	private String description;
	
	private String id;
	
	private String last_update;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private String name;
	
	private String street_address;

	public int getAvailable_spaces() {
		return available_spaces;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return City.SantaMonica.getId()+"_"+id;
	}

	public String getLast_update() {
		return last_update;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getStreet_address() {
		return street_address;
	}
	
}
