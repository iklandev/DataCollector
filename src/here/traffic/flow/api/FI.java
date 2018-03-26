package here.traffic.flow.api;

import java.util.List;

/**
 * Entry for each Flow item in the specified direction. (FLOW_ITEM)
 * This is the main item that incorporates flow information for a single
 * location from traffic services. It describes all of the current flow
 * information in terms of travel times and speeds for a stretch of road. This
 * section includes the current flow data and predictive data.
 * 
 * @author ivan
 *
 */
/**
 * @author i_kla
 *
 */
public class FI {

	/**
	 * This represents the current flow conditions of this location.
	 * (CURRENT_FLOW)
	 * Required.
	 */
	private List<CF> CF;
	
	/**
	 * This represents the predictive speeds for the next 12 hours for this location. 0-Many.
	 * (PREDICTIVE_FLOW)
	 */
	private PF PF;
	
	/**
	 * Provided if TMC is the location referencing type for the containing RWS.
	 */
	private TMC TMC;
	
	/**
	 * Provided if GENERIC_DLR is the location referencing type for the
	 * containing RWS.
	 */
	private GENERICDLR GENERIC_DLR;
	
	/**
	 * Provided if SHP is the location referencing type for the containing RWS.
	 * Or, if the provider wishes to include shape points, further describing
	 * the referenced road segment, it can also use this element.
	 */
	private SHP SHP;

	public SHP getSHP() {
		return SHP;
	}

	public List<CF> getCF() {
		return CF;
	}

	public PF getPF() {
		return PF;
	}

	public TMC getTMC() {
		return TMC;
	}

	public GENERICDLR getGENERIC_DLR() {
		return GENERIC_DLR;
	}

}
