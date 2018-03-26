package data.collector.parking.spaces;

import java.util.List;

public class WinchesterResponse {
	
	private String label;
	
	private List<WinchesterLotInfo> entries;
	
	public String getLabel() {
		return label;
	}

	public List<WinchesterLotInfo> getEntries() {
		return entries;
	}

	public class WinchesterLotInfo {
		
		private String id;
		
		private String label;
		
		private int occupancy;
		
		private int capacity;
		
		private int direction;
		
		private String updated;
		
		public int getFreeSpaces() {
			
			return capacity-occupancy;
			
		}

		public String getId() {
			return City.Winchester.getId()+"_"+id;
		}

		public String getLabel() {
			return label;
		}

		public int getOccupancy() {
			return occupancy;
		}

		public int getCapacity() {
			return capacity;
		}

		public int getDirection() {
			return direction;
		}

		public String getUpdated() {
			return updated;
		}
		
	}

}
