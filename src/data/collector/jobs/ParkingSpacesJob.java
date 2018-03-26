package data.collector.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import data.collector.parking.spaces.City;
import data.collector.parking.spaces.ParkingSpacesDataCollector;

public class ParkingSpacesJob implements Job {

	public static final String CITY_PARAM = "CITY_CODE";
	
	private static Logger logger = Logger.getLogger(ParkingSpacesJob.class.getName());
	
	private City city;
	
	public ParkingSpacesJob() {
		
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException  {
		
		logger.info("Start ParkingSpacesJob");
		JobDataMap data = context.getJobDetail().getJobDataMap();
        this.city = City.getCity(data.getInt(CITY_PARAM));
        
        logger.info("Execute ParkingSpacesJob for city: " + this.city.name());
        
		switch(this.city){
		
		case Pittsburgh:
			try {
				ParkingSpacesDataCollector.getPittsburghFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case Madison:
			try {
				ParkingSpacesDataCollector.getMadisonFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case Asheville:
			try {
				ParkingSpacesDataCollector.getAshevilleFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case AnnArbor:
			try {
				ParkingSpacesDataCollector.getAnnArborFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case Seattle:
			try {
				ParkingSpacesDataCollector.getSeattleFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case SantaBarbara:
			try {
				ParkingSpacesDataCollector.getSantaBarbaraFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;	
		case Winchester:
			try {
				ParkingSpacesDataCollector.getWinchesterFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		case SantaMonica:
			try {
				ParkingSpacesDataCollector.getSantaMonicaFreeParkingSpaces();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			break;
		default:
			System.out.println("No city");
			break;
		}
		
		logger.info("End ParkingSpacesJob for city: " + this.city.name());
		
	}

}
