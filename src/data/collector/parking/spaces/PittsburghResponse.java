package data.collector.parking.spaces;

import java.math.BigDecimal;

public class PittsburghResponse {
	
	private String name;
	
	private String id;
	
	private BigDecimal lat;
	
	private BigDecimal lon;
	
	private Status status;

	public String getName() {
		return name;
	}

	public String getId() {
		return City.Pittsburgh.getId()+"_"+id;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public BigDecimal getLon() {
		return lon;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public class Status {
		
		private int percent_full;
		
		private int percent_available;
		
		private String state;
		
		private String display_spaces;
		
		private int actual_spaces;

		public String getState() {
			return state;
		}

		public int getActual_spaces() {
			return actual_spaces;
		}

		public int getPercent_full() {
			return percent_full;
		}

		public int getPercent_available() {
			return percent_available;
		}

		public String getDisplay_spaces() {
			return display_spaces;
		}
				
	}

}
