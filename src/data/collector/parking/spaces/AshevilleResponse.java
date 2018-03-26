package data.collector.parking.spaces;

import java.math.BigDecimal;
import java.util.List;

public class AshevilleResponse {

	private List <AshevilleLotInfo> decks;
	
	public List<AshevilleLotInfo> getDecks() {
		return decks;
	}

	public class AshevilleLotInfo {
		
		private String name;
		
		private int available;
		
		private BigDecimal [] coords;

		public String getName() {
			return name;
		}

		public int getAvailable() {
			return available;
		}

		public BigDecimal[] getCoords() {
			return coords;
		}
		
		public BigDecimal getLatitude() {
			return this.coords[0];
		}
		
		public BigDecimal getLongitude() {
			return this.coords[1];
		}
		
		public String getId(){
			return City.Asheville.getId()+"_"+name.substring(0,2).toUpperCase();
		}
	}
}
