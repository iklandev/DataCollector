package here.traffic.flow.api;

import java.math.BigDecimal;

/**
 * For each city (for all parking lots), traffic info will be requested in form
 * of circle with geo center and radius. Here API will return traffic info for
 * the streets inside the circle.
 * 
 * @author ivan
 *
 */
public enum HereMapCityProx {

	Pittsburgh (2600, new BigDecimal(40.443093), new BigDecimal(-80.000510)),
	Madison (2400, new BigDecimal(43.073183), new BigDecimal(-89.389554)),
	Asheville (1500, new BigDecimal(35.594489), new BigDecimal(-82.553865)),
	AnnArbor (2200, new BigDecimal(42.277769), new BigDecimal(-83.741848)),
	Seattle (2700, new BigDecimal(47.607132), new BigDecimal(-122.337076)),
	SantaBarbara (2500, new BigDecimal(34.419779), new BigDecimal(-119.699542)),
	Winchester (4500, new BigDecimal(51.052129), new BigDecimal(-1.320391)),
	SantaMonica (5000, new BigDecimal(34.016925), new BigDecimal(-118.494557));
	
	// Radius for the circle
	private int radius;
	
	//Latitude for the center
	private BigDecimal latitude;
	
	//Longitude for the center
	private BigDecimal longitude;
	
	HereMapCityProx (int radius, BigDecimal latitude, BigDecimal longitude){
		this.radius = radius;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getRadius() {
		return radius;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}
	
}
