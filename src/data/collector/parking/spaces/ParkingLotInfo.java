package data.collector.parking.spaces;

import data.collector.parking.spaces.AshevilleResponse.AshevilleLotInfo;
import data.collector.parking.spaces.WinchesterResponse.WinchesterLotInfo;

public class ParkingLotInfo {
	
	private String date;
	
	private String lotId;
	
	private String cityId;
		
	private String lotName;
	
	private int freeSpaces;
	
	
	
	public ParkingLotInfo(PittsburghResponse pittsburghResponse) {
		this.date = City.Pittsburgh.getCurrentTime();
		this.lotId = pittsburghResponse.getId();
		this.cityId = ""+City.Pittsburgh.getId();
		this.lotName = pittsburghResponse.getName();
		this.freeSpaces = pittsburghResponse.getStatus().getActual_spaces();
	}

	public ParkingLotInfo(MadisonResponse madisonResponse) {
		this.date = City.Madison.getCurrentTime();
		this.lotId = madisonResponse.getId();
		this.cityId = ""+City.Madison.getId();
		this.lotName = madisonResponse.getName();
		this.freeSpaces = madisonResponse.getVacant_stalls();
	}

	public ParkingLotInfo(AshevilleLotInfo ashevilleLotInfo) {
		this.date = City.Asheville.getCurrentTime();
		this.lotId = ashevilleLotInfo.getId();
		this.cityId = ""+City.Asheville.getId();
		this.lotName = ashevilleLotInfo.getName();
		this.freeSpaces = ashevilleLotInfo.getAvailable();
	}

	public ParkingLotInfo(AnnArborResponse annArborResponse) {
		this.date = City.AnnArbor.getCurrentTime();
		this.lotId = annArborResponse.getId();
		this.cityId = ""+City.AnnArbor.getId();
		this.lotName = annArborResponse.getName();
		this.freeSpaces = annArborResponse.getFreeSpaces();
	}

	public ParkingLotInfo(SeattleResponse seattleResponse) {
		this.date = City.Seattle.getCurrentTime();
		this.lotId = seattleResponse.getId();
		this.cityId = ""+City.Seattle.getId();
		this.lotName = seattleResponse.getGarageName();
		this.freeSpaces = seattleResponse.getVacantSpaces();
	}

	public ParkingLotInfo(SantaBarbaraResponse santaBarbaraResponse) {
		this.date = City.SantaBarbara.getCurrentTime();
		this.lotId = santaBarbaraResponse.getId();
		this.cityId = ""+City.SantaBarbara.getId();
		this.lotName = santaBarbaraResponse.getCarparkName();
		this.freeSpaces = santaBarbaraResponse.getFreeSpaces();

	}

	public ParkingLotInfo(WinchesterLotInfo winchesterLotInfo) {
		this.date = City.Winchester.getCurrentTime();
		this.lotId = winchesterLotInfo.getId();
		this.cityId = ""+City.Winchester.getId();
		this.lotName = winchesterLotInfo.getLabel();
		this.freeSpaces = winchesterLotInfo.getFreeSpaces();

	}

	public ParkingLotInfo(SantaMonicaResponse santaMonicaResponse) {
		this.date = City.SantaMonica.getCurrentTime();
		this.lotId = santaMonicaResponse.getId();
		this.cityId = ""+City.SantaMonica.getId();
		this.lotName = santaMonicaResponse.getName();
		this.freeSpaces = santaMonicaResponse.getAvailable_spaces();

	}

	public String getDate() {
		return date;
	}

	public String getLotId() {
		return lotId;
	}

	public String getCityId() {
		return cityId;
	}

	public String getLotName() {
		return lotName;
	}

	public int getFreeSpaces() {
		return freeSpaces >=0 ? freeSpaces : 0;
	}
	
}
