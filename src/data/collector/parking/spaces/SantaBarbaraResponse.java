package data.collector.parking.spaces;

public class SantaBarbaraResponse {
	
	private String CarparkNo;
	
	private String CarparkAbbr;
	
	private String CarparkDesig;
	
	private int CountingCategoryNo;
	
	private String CountingCategory;
	
	private int FreeLimit;
	
	private int OccupancyLimit;
	
	private int CurrentLevel;
	
	private int Reservation;
	
	private int Capacity;
	
	private String CarparkName;
	
	private String TimeStamp;

	public String getCarparkNo() {
		return CarparkNo;
	}

	public String getCarparkAbbr() {
		return CarparkAbbr;
	}

	public String getCarparkDesig() {
		return CarparkDesig;
	}

	public int getCountingCategoryNo() {
		return CountingCategoryNo;
	}

	public String getCountingCategory() {
		return CountingCategory;
	}

	public int getFreeLimit() {
		return FreeLimit;
	}

	public int getOccupancyLimit() {
		return OccupancyLimit;
	}

	public int getCurrentLevel() {
		return CurrentLevel;
	}

	public int getReservation() {
		return Reservation;
	}

	public int getCapacity() {
		return Capacity;
	}

	public String getCarparkName() {
		return CarparkName;
	}

	public String getTimeStamp() {
		return TimeStamp;
	}
	
	public String getId () {
		return City.SantaBarbara.getId()+"_"+CarparkNo;
	}
	
	public int getFreeSpaces(){
		return OccupancyLimit-CurrentLevel;
	}

}
