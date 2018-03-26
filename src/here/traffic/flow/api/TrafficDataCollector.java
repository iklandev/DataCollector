package here.traffic.flow.api;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import data.collector.main.Main;
import data.collector.parking.spaces.City;

public class TrafficDataCollector {

	private static final String PITTSBURG_CSV_FILE = "pittsburgh_traffic.csv";

	private static final String MADISON_CSV_FILE = "madison_traffic.csv";
	
	private static final String ASHEVILLE_CSV_FILE = "asheville_traffic.csv";
	
	private static final String ANN_ARBOR_CSV_FILE = "annarbor_traffic.csv";
	
	private static final String SEATTLE_CSV_FILE = "seattle_traffic.csv";
	
	private static final String SANTA_BARBARA_CSV_FILE = "santabarbara_traffic.csv";
	
	private static final String WINCHESTER_CSV_FILE = "winchester_traffic.csv";
	
	private static final String SANTA_MONICA_CSV_FILE = "santamonica_traffic.csv";
	
	static Logger logger = Logger.getLogger(TrafficDataCollector.class.getName());
	
	public static String getCSVFileNameByCity (City city){
		
	switch(city){
		
		case Pittsburgh:
			return city.getCurrentDate()+"_"+PITTSBURG_CSV_FILE;
		case Madison:
			return city.getCurrentDate()+"_"+MADISON_CSV_FILE;
		case Asheville:
			return city.getCurrentDate()+"_"+ASHEVILLE_CSV_FILE;
		case AnnArbor:
			return city.getCurrentDate()+"_"+ANN_ARBOR_CSV_FILE;
		case Seattle:
			return city.getCurrentDate()+"_"+SEATTLE_CSV_FILE;
		case SantaBarbara:
			return city.getCurrentDate()+"_"+SANTA_BARBARA_CSV_FILE;	
		case Winchester:
			return city.getCurrentDate()+"_"+WINCHESTER_CSV_FILE;
		case SantaMonica:
			return city.getCurrentDate()+"_"+SANTA_MONICA_CSV_FILE;
		default:
			System.out.println("No city");
			return "NaN";
		}
	}
	
	private static void writeToCSVFile(City city, String jsonString) throws IOException {
		Path filePath = Paths.get(System.getProperty("user.home"), Main.HOME_APP_DIR, Main.HOME_APP_TRAFFIC_DIR,getCSVFileNameByCity(city));
		try {

			StringBuilder csvLine = new StringBuilder();
			csvLine.append(city.getCurrentTime() + ";");
			csvLine.append(city.getId() + ";");
			csvLine.append(jsonString + "\n");
			Files.write(filePath, csvLine.toString().getBytes(), CREATE, APPEND);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static void collectTrafficDataForCity(City city) throws MalformedURLException, IOException {
		
		logger.info("Enter in collectTrafficDataForCity for city: "+city.name());
		
		HereMapService hms = new HereMapService(city);
		String jsonString = hms.executeService();
		writeToCSVFile(city, jsonString);
		
		logger.info("Exit in collectTrafficDataForCity for city: "+city.name());
	}
	
}
