package here.traffic.flow.api;

import java.util.List;

/**
 * TrafficML flow data feed which includes both current and predictive traffic flow
 * elements, and uses both TMC-based and DLR-based location referencing.
 * 
 * @author ivan
 *
 */
public class HereTrafficML {

	/**
	 * Collection of RW elements. In the normal case where there will be only
	 * one RWS element.
	 * Required.
	 */
	private List<RWS> RWS;
	
	/**
	 * The timestamp in UTC/GMT of the feeds creation. The timestamp format
	 * follows the ISO-8601 specification. Example: 2011-07-04T22:02:46Z
	 * Required.
	 */
	private String CREATED_TIMESTAMP;
	
	/**
	 * This is the version of the feed which directly correlates to the version
	 * of the spec used to define the feed.
	 * Required.
	 */
	private String VERSION;
	
	/**
	 * This is the version of the data that was used to create the feed. Format:
	 * (YYYYQQ). 
	 * Required.
	 */
	private String MAP_VERSION;

	/**
	 * Defines the units of measure for all data. Possible values include
	 * “metric” or “imperial”. “metric” uses kph for speed and km for distance,
	 * while “imperial” uses mph for speed and miles for distance. This
	 * attribute can be overridden for a particular RWS element.
	 * Required.
	 */
	private String UNITS;

	public List<RWS> getRWS() {
		return RWS;
	}

	public String getCREATED_TIMESTAMP() {
		return CREATED_TIMESTAMP;
	}

	public String getVERSION() {
		return VERSION;
	}

	public String getMAP_VERSION() {
		return MAP_VERSION;
	}

	public String getUNITS() {
		return UNITS;
	}
	
	
}
