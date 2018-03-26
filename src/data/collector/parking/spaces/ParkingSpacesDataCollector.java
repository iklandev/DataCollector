package data.collector.parking.spaces;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import data.collector.main.Main;
import data.collector.parking.spaces.AshevilleResponse.AshevilleLotInfo;
import data.collector.parking.spaces.WinchesterResponse.WinchesterLotInfo;

public class ParkingSpacesDataCollector {

	private static final String PITTSBURG_URL = "http://parkpgh.org/";
	private static final String PITTSBURG_CSV_FILE = "pittsburgh.csv";
	
	private static final String MADISON_URL = "http://www.cityofmadison.com/parking-utility/data/ramp-availability.json";
	private static final String MADISON_CSV_FILE = "madison.csv";
	
	private static final String ASHEVILLE_URL = "https://s3.amazonaws.com/asheville-parking-decks/spaces.json";
	private static final String ASHEVILLE_CSV_FILE = "asheville.csv";
	
	private static final String ANN_ARBOR_URL = "https://payment.rpsa2.com/LocationAndRate/SpaceAvailability";
	private static final String ANN_ARBOR_CSV_FILE = "annarbor.csv";
	
	private static final String SEATTLE_URL = "http://web6.seattle.gov/sdot/wsvcEparkGarageOccupancy/Occupancy.asmx/GetGarageList?prmGarageID=G&prmMyCallbackFunctionName=";
	private static final String SEATTLE_CSV_FILE = "seattle.csv";
	
	private static final String SANTA_BARBARA_URL = "https://www.santabarbaraca.gov/civicax/parking/api/status/";
	private static final String SANTA_BARBARA_CSV_FILE = "santabarbara.csv";
	
	private static final String WINCHESTER_URL = "https://winchester.noggin.bi/carpark/api/occupancies";
	private static final String WINCHESTER_CSV_FILE = "winchester.csv";
	
	private static final String SANTA_MONICA_URL = "https://parking.api.smgov.net/lots";
	private static final String SANTA_MONICA_CSV_FILE = "santamonica.csv";
	
	static Logger logger = Logger.getLogger(ParkingSpacesDataCollector.class.getName());
	
	private static void writeToCSVFile (List<ParkingLotInfo> lots, String fileName, City city) throws IOException {
		
		Path filePath = Paths.get(System.getProperty("user.home"), Main.HOME_APP_DIR, Main.HOME_APP_PARKING_DIR, city.getCurrentDate()+"_"+fileName);
		try {

			for (ParkingLotInfo lot : lots) {
				StringBuilder csvLine = new StringBuilder();
				csvLine.append(lot.getDate()+";");
				csvLine.append(lot.getLotId()+";");
				csvLine.append(lot.getCityId()+";");
				csvLine.append(lot.getLotName()+";");
				csvLine.append(lot.getFreeSpaces()+"\n");
				Files.write(filePath, csvLine.toString().getBytes(), CREATE, APPEND);
			}
			
			
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static void getPittsburghFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getPittsburghFreeParkingSpaces");
		Document doc =Jsoup.connect(PITTSBURG_URL).get();
		Elements scriptElements = doc.getElementsByTag("script");
		PittsburghResponse[] freeSpaces = null;

		 searchloop: 
			 for (Element element :scriptElements ){                
				 for (DataNode node : element.dataNodes()) {
					 if (node.getWholeData().contains("park.lots")){
						 Scanner scanner = new Scanner(node.getWholeData());
						 while (scanner.hasNextLine()) {
							 String line = scanner.nextLine();
							 if (line.contains("park.lots")){
								 String [] parts = line.split("=");
								 
								 Gson g = new Gson(); 
								 freeSpaces = g.fromJson(parts[1].substring(0, parts[1].length()-1), PittsburghResponse[].class);
								 scanner.close();
								 break searchloop;
							 }
						 }
						 scanner.close();
					 }
				 }
			 }
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (PittsburghResponse pittsburghResponse : freeSpaces) {
				lots.add(new ParkingLotInfo(pittsburghResponse));
			}
			writeToCSVFile(lots, PITTSBURG_CSV_FILE, City.Pittsburgh);
		}
		
		
		logger.info("Exit from getPittsburghFreeParkingSpaces");
		
	}
	
	public static void getMadisonFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getMadisonFreeParkingSpaces");
		String jsonString = IOUtils.toString(new URL(MADISON_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		MadisonResponse[] freeSpaces = g.fromJson(jsonString, MadisonResponse[].class);
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (MadisonResponse madisonResponse : freeSpaces) {
				lots.add(new ParkingLotInfo(madisonResponse));
			}
			writeToCSVFile(lots, MADISON_CSV_FILE, City.Madison);
		}
		
		logger.info("Exit from getMadisonFreeParkingSpaces");
		
	}
	
	
	public static void getAshevilleFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getAshevilleFreeParkingSpaces");
		String jsonString = IOUtils.toString(new URL(ASHEVILLE_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		AshevilleResponse freeSpaces = g.fromJson(jsonString, AshevilleResponse.class);
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (AshevilleLotInfo ashevilleLotInfo : freeSpaces.getDecks()) {
				lots.add(new ParkingLotInfo(ashevilleLotInfo));
			}
			writeToCSVFile(lots, ASHEVILLE_CSV_FILE, City.Asheville);
		}
		logger.info("Exit from getAshevilleFreeParkingSpaces");
		
	}
	
	public static void getAnnArborFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getAnnArborFreeParkingSpaces");
		Document doc =Jsoup.connect(ANN_ARBOR_URL).get();
		Element table = doc.select("table").first();
		Elements rows = table.select("tr");

		List<AnnArborResponse> freeSpaces = new ArrayList<AnnArborResponse>();
		for (int i = 1; i < rows.size(); i++) { // first row is the col names so
												// skip it.
			Element col = rows.get(i).select("td").first();

			String geoLink = col.select("a").first().attr("href").split(":")[1];
			String[] dataArray = col.text().split("as of at");
			String [] partsArray = dataArray[0].split("-");
			int spacesInfo = Integer.parseInt(partsArray[partsArray.length-1].trim().split(" ")[0].trim());

			freeSpaces.add(new AnnArborResponse(dataArray[0].split("-")[0].trim(), spacesInfo,
					new BigDecimal(geoLink.split(",")[0].trim()), new BigDecimal(geoLink.split(",")[1].trim()),
					dataArray[1].trim()));
		}
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (AnnArborResponse annArborResponse : freeSpaces) {
				lots.add(new ParkingLotInfo(annArborResponse));
			}
			writeToCSVFile(lots, ANN_ARBOR_CSV_FILE, City.AnnArbor);
		}
				
		logger.info("Exit from getAnnArborFreeParkingSpaces");
		
	}
	
	public static void getSeattleFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getSeattleFreeParkingSpaces");
		String jsonString = IOUtils.toString(new URL(SEATTLE_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		SeattleResponse [] freeSpaces = g.fromJson(jsonString.substring(1, jsonString.length()-2), SeattleResponse[].class);

		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (SeattleResponse seattleResponse : freeSpaces) {
				lots.add(new ParkingLotInfo(seattleResponse));
			}
			writeToCSVFile(lots, SEATTLE_CSV_FILE, City.Seattle);
		}
		
		logger.info("Exit from getSeattleFreeParkingSpaces");
		
	}
	
	public static void getSantaBarbaraFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getSantaBarbaraFreeParkingSpaces");
		
		String jsonString = IOUtils.toString(new URL(SANTA_BARBARA_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		SantaBarbaraResponse[] freeSpaces = g.fromJson(jsonString, SantaBarbaraResponse[].class);
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (SantaBarbaraResponse santaBarbaraResponse : freeSpaces) {
				if (santaBarbaraResponse.getOccupancyLimit()!=9999){
					lots.add(new ParkingLotInfo(santaBarbaraResponse));
				}
			}
			writeToCSVFile(lots, SANTA_BARBARA_CSV_FILE, City.SantaBarbara);
		}
		logger.info("Exit from getSantaBarbaraFreeParkingSpaces");
		
	}
	
	public static void getWinchesterFreeParkingSpaces() throws MalformedURLException, IOException {
		
		logger.info("Enter in getWinchesterFreeParkingSpaces");
		
		String jsonString = IOUtils.toString(new URL(WINCHESTER_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		WinchesterResponse freeSpaces = g.fromJson(jsonString, WinchesterResponse.class);

		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (WinchesterLotInfo winchesterLotInfo : freeSpaces.getEntries()) {
				if (winchesterLotInfo.getCapacity()!=0){
					lots.add(new ParkingLotInfo(winchesterLotInfo));
				}
			}
			writeToCSVFile(lots, WINCHESTER_CSV_FILE, City.Winchester);
		}
		
		logger.info("Exit from getWinchesterFreeParkingSpaces");
		
	}
	
	public static void getSantaMonicaFreeParkingSpaces () throws MalformedURLException, IOException {
		
		logger.info("Enter in getSantaMonicaFreeParkingSpaces");
		
		String jsonString = IOUtils.toString(new URL(SANTA_MONICA_URL), Charset.forName("UTF-8"));
		Gson g = new Gson(); 
		SantaMonicaResponse[] freeSpaces = g.fromJson(jsonString, SantaMonicaResponse[].class);
		
		if (freeSpaces!=null){
			List<ParkingLotInfo> lots = new ArrayList<ParkingLotInfo>();
			for (SantaMonicaResponse santaMonicaResponse : freeSpaces) {
				lots.add(new ParkingLotInfo(santaMonicaResponse));
			}
			writeToCSVFile(lots, SANTA_MONICA_CSV_FILE, City.SantaMonica);
		}
		
		logger.info("Exit from getSantaMonicaFreeParkingSpaces");
		
	}
}
