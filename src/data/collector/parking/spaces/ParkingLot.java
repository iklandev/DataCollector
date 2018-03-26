package data.collector.parking.spaces;

import java.math.BigDecimal;

public enum ParkingLot {

	STANWIX_11("1_36", 1, new BigDecimal(40.43910031), new BigDecimal(-80.00560641), null),
	SIXTH_AND_PENN("1_5", 1, new BigDecimal(40.44256246), new BigDecimal(-80.00246286), null),
	NINETH_AND_PENN("1_30", 1, new BigDecimal(40.44408526), new BigDecimal(-79.99856293), null),
	CONVENTION_CENTER("1_4", 1, new BigDecimal(40.445537), new BigDecimal(-79.995132), null),
	FIRST_AVENUE("1_42", 1, new BigDecimal(40.43505001), new BigDecimal(-79.99605775), null),
	FT_DUQUESNE_AND_SIXTH("1_26", 1, new BigDecimal(40.44360761), new BigDecimal(-80.00285983), null),
	GATEWAY_CENTER_GARAGE("1_10", 1, new BigDecimal(40.4410305), new BigDecimal(-80.0060234), null),
	GENERAL_ROBINSON_GARAGE("1_33", 1, new BigDecimal(40.44747776), new BigDecimal(-80.00951171), null),
	GRANT_STREET_CENTER("1_28", 1, new BigDecimal(40.44537942), new BigDecimal(-79.99277472), null),
	MANOR_GARAGE("1_37", 1, new BigDecimal(40.43718135), new BigDecimal(-79.9960953), null),
	MARKET_SQUARE("1_14", 1, new BigDecimal(40.4401962), new BigDecimal(-80.0011212), null),
	MELLON_SQUARE("1_39", 1, new BigDecimal(40.44088856), new BigDecimal(-79.99746323), null),
	NORTHSHORE_GARAGE("1_34", 1, new BigDecimal(40.44889432), new BigDecimal(-80.00296712), null),
	NOVA_PLACE_GARAGE("1_13", 1, new BigDecimal(40.45062936), new BigDecimal(-80.00481571), null),
	OLIVER("1_41", 1, new BigDecimal(40.44089673), new BigDecimal(-79.99906182), null),
	ONE_OXFORD_CENTRE_GARAGE("1_11", 1, new BigDecimal(40.43767958), new BigDecimal(-79.99816383), null),
	PPG_GARAGE("1_35", 1, new BigDecimal(40.43968823), new BigDecimal(-80.00261307), null),
	SMITHFIELD_AND_LIBERTY("1_27", 1, new BigDecimal(40.4427176), new BigDecimal(-79.99783874), null),
	THEATER_SQUARE("1_2", 1, new BigDecimal(40.443869), new BigDecimal(-80.00061), null),
	THIRD_AVENUE("1_38", 1, new BigDecimal(40.43946776), new BigDecimal(-80.00235558), null),
	THREE_PNC_PLAZA("1_25", 1, new BigDecimal(40.44123151), new BigDecimal(-80.0011754), null),
	TOWN_PLACE("1_6", 1, new BigDecimal(40.440533), new BigDecimal(-80.004394), null),
	US_STEEL_TOWER("1_12", 1, new BigDecimal(40.441355), new BigDecimal(-79.994853), null),
	WOOD_ALLIES("1_40", 1, new BigDecimal(40.43842255), new BigDecimal(-80.00282764), null),
	BRAYTON_LOT("2_9", 2, new BigDecimal(43.076751), new BigDecimal(-89.38022), 245),
	CAPITOL_SQUARE_NORTH_GARAGE("2_6", 2, new BigDecimal(43.07764), new BigDecimal(-89.38326), 612),
	GOVERNMENT_EAST_GARAGE("2_3", 2, new BigDecimal(43.073936), new BigDecimal(-89.380267), 516),
	OVERTURE_CENTER_GARAGE("2_1", 2, new BigDecimal(43.073356), new BigDecimal(-89.389362), 621),
	STATE_STREET_CAMPUS_GARAGE("2_5", 2, new BigDecimal(43.074067), new BigDecimal(-89.3966), 1062),
	STATE_STREET_CAPITOL_GARAGE("2_2", 2, new BigDecimal(43.075482), new BigDecimal(-89.388118), 840),
	RANKIN_AVE("3_RA", 3, new BigDecimal(35.596133), new BigDecimal(-82.554072), 262),
	CIVIC_CENTER("3_CI", 3, new BigDecimal(35.596867), new BigDecimal(-82.554126), 550),
	WALL_STREET("3_WA", 3, new BigDecimal(35.594614), new BigDecimal(-82.557025), 232),
	BILTMORE_AVE("3_BI", 3, new BigDecimal(35.592445), new BigDecimal(-82.551773), 404),
	FOURTH_AND_WASHINGTON_STRUCTURE("4_FO1", 4, new BigDecimal(42.2805163), new BigDecimal(-83.7481832), 281),
	FIRST_AND_WASHINGTON_STRUCTURE("4_FI2", 4, new BigDecimal(42.2804774), new BigDecimal(-83.7500788), 242),
	MAYNARD_STRUCTURE("4_MA3", 4, new BigDecimal(42.2789278), new BigDecimal(-83.7421086), 797),
	FOREST_STRUCTURE("4_FO4", 4, new BigDecimal(42.2743915), new BigDecimal(-83.733201), 854),
	FOURTH_AND_WILLIAM_STRUCTURE("4_FO5", 4, new BigDecimal(42.2784615), new BigDecimal(-83.7477646), 847),
	LIBERTY_SQUARE_STRUCTURE("4_LI6", 4, new BigDecimal(42.280283), new BigDecimal(-83.7428007), 573),
	ANN_ASHLEY_STRUCTURE("4_AN7", 4, new BigDecimal(42.2826333), new BigDecimal(-83.7496376), 839),
	LIBRARY_LANE_STRUCTURE("4_LI8", 4, new BigDecimal(42.2787552), new BigDecimal(-83.7455673), 744),
	SOUTH_ASHLEY_LOT("4_SO9", 4, new BigDecimal(42.2793726), new BigDecimal(-83.7498497), 138),
	FIRST_AND_HURON_LOT("4_FI10", 4, new BigDecimal(42.281444), new BigDecimal(-83.749812), 168),
	PIKE_PLACE("5_G2", 5, new BigDecimal(47.608848), new BigDecimal(-122.341942), null),
	BUTLER_GARAGE("5_G17", 5, new BigDecimal(47.602265), new BigDecimal(-122.333070), null),
	FIRST_AND_COLUMBIA("5_G16", 5, new BigDecimal(47.602749), new BigDecimal(-122.334931), null),
	STADIUM_PLACE("5_G15", 5, new BigDecimal(47.597644), new BigDecimal(-122.333049), null),
	PACIFIC_PLACE("5_G4", 5, new BigDecimal(47.613155), new BigDecimal(-122.335458), null),
	PSP_COBB("5_G7", 5, new BigDecimal(47.608978), new BigDecimal(-122.336138), null),
	THIRD_AND_STEWART("5_G3", 5, new BigDecimal(47.611310), new BigDecimal(-122.339771), null),
	WAC_PARKING("5_G11", 5, new BigDecimal(47.610327), new BigDecimal(-122.334067), null),
	CONVENTION_CENTER_5("5_G9", 5, new BigDecimal(47.611518), new BigDecimal(-122.332894), null),
	WEST_EDGE("5_G22", 5, new BigDecimal(47.609566), new BigDecimal(-122.338821), null),
	BELL_STREET_PIER("5_G13", 5, new BigDecimal(47.613033), new BigDecimal(-122.350684), null),
	HILLCLIMB_GARAGE("5_G14", 5, new BigDecimal(47.607690), new BigDecimal(-122.341156), null),
	WATERFRONT_PLACE("5_G19", 5, new BigDecimal(47.604246), new BigDecimal(-122.337949), null),
	WATERMARK_GARAGE("5_G18", 5, new BigDecimal(47.605427), new BigDecimal(-122.338199), null),
	LOT_2("6_7", 6, new BigDecimal(34.420250), new BigDecimal(-119.701937), null),
	LOT_3("6_9", 6, new BigDecimal(34.421356), new BigDecimal(-119.703367), null),
	LOT_4("6_13", 6, new BigDecimal(34.422139), new BigDecimal(-119.704554), null),
	LOT_5("6_14", 6, new BigDecimal(34.423078), new BigDecimal(-119.705953), null),
	LOT_6("6_0", 6, new BigDecimal(34.424597), new BigDecimal(-119.704160), null),
	LOT_7("6_1", 6, new BigDecimal(34.423415), new BigDecimal(-119.702723), null),
	LOT_8("6_2", 6, new BigDecimal(34.422448), new BigDecimal(-119.702037), null),
	LOT_9("6_3", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680), null),
	LOT9_2_ROOF("6_5", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680), null),
	LOT_10("6_8", 6, new BigDecimal(34.419143), new BigDecimal(-119.696836), null),
	LOT_11("6_11", 6, new BigDecimal(34.417955), new BigDecimal(-119.695401), null),
	LOT_12("6_10", 6, new BigDecimal(34.415290), new BigDecimal(-119.694084), null),
	LOT_13("6_12", 6, new BigDecimal(34.414033), new BigDecimal(-119.692946), null),
	CHESIL_ST_MSCP("7_1", 7, new BigDecimal(51.060328), new BigDecimal(-1.305676), null),
	TOWER_ST("7_3", 7, new BigDecimal(51.064961), new BigDecimal(-1.318118), null),
	THE_BROOKS("7_7", 7, new BigDecimal(51.063278), new BigDecimal(-1.311710), null),
	MIDDLEBROOK_ST("7_10", 7, new BigDecimal(51.063438), new BigDecimal(-1.311099), null),
	SOUTH_WINCHESTER_PANDR("7_2", 7, new BigDecimal(51.032660), new BigDecimal(-1.328583), null),
	BARFIELD_PANDR("7_8", 7, new BigDecimal(51.054308), new BigDecimal(-1.306820), null),
	ST_CATHERINES_PANDR("7_9", 7, new BigDecimal(51.050560), new BigDecimal(-1.305766), null),
	PITT_PANDR("7_12", 7, new BigDecimal(51.053344), new BigDecimal(-1.348075), null),
	BEACH_HOUSE_LOT("8_667276", 8, new BigDecimal(34.023972), new BigDecimal(-118.512472), null),
	STRUCTURE_1("8_8349", 8, new BigDecimal(34.018203), new BigDecimal(-118.497761), null),
	STRUCTURE_2("8_8350", 8, new BigDecimal(34.016861), new BigDecimal(-118.498889), null),
	STRUCTURE_3("8_8351", 8, new BigDecimal(34.017061), new BigDecimal(-118.496456), null),
	STRUCTURE_4("8_8352", 8, new BigDecimal(34.015967), new BigDecimal(-118.497917), null),
	STRUCTURE_5("8_8353", 8, new BigDecimal(34.015231), new BigDecimal(-118.494303), null),
	STRUCTURE_6("8_8354", 8, new BigDecimal(34.014328), new BigDecimal(-118.495875), null),
	STRUCTURE_9("8_8357", 8, new BigDecimal(34.019575), new BigDecimal(-118.499378), null),
	LOT_8_NORTH("8_765678", 8, new BigDecimal(34.021000), new BigDecimal(-118.508333), null),
	LOT_3_NORTH("8_765178", 8, new BigDecimal(34.016806), new BigDecimal(-118.502750), null),
	LOT_1_NORTH("8_764978", 8, new BigDecimal(34.010806), new BigDecimal(-118.497361), null),
	PIER_DECK("8_8068", 8, new BigDecimal(34.009333), new BigDecimal(-118.496389), null),
	LOT_4_SOUTH("8_765283", 8, new BigDecimal(34.003028), new BigDecimal(-118.488639), null),
	LOT_5_SOUTH("8_765383", 8, new BigDecimal(33.998833), new BigDecimal(-118.484722), null),
	CIVIC_CENTER_8("8_6767", 8, new BigDecimal(34.01158), new BigDecimal(-118.48997), null),
	LIBRARY("8_76", 8, new BigDecimal(34.01900), new BigDecimal(-118.49361), null),
	STRUCTURE_7("8_8355", 8, new BigDecimal(34.01444), new BigDecimal(-118.49372), null),
	STRUCTURE_8("8_8356", 8, new BigDecimal(34.01289), new BigDecimal(-118.49372), null);

	//Id of the lot
	private String id;
	
	//City Id of the lot
	private int cityId;

	// Latitude for the lot
	private BigDecimal latitude;

	// Longitude for the lot
	private BigDecimal longitude;
	
	//Number of all spaces in the garage
	private Integer spaces;
	
	ParkingLot (String id, int cityId, BigDecimal latitude, BigDecimal longitude, Integer spaces) {
		this.id = id;
		this.cityId = cityId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.spaces = spaces;	
	}

	public String getId() {
		return id;
	}

	public int getCityId() {
		return cityId;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public Integer getSpaces() {
		return spaces;
	}
	
	public static ParkingLot getLot(String id) {
	      for (ParkingLot l : ParkingLot.values()) {
	          if (l.id.equals(id)) return l;
	      }
	      throw new IllegalArgumentException("Leg not found. Amputated?");
	   }
}
