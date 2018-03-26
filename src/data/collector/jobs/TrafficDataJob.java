package data.collector.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import data.collector.parking.spaces.City;
import here.traffic.flow.api.TrafficDataCollector;

public class TrafficDataJob implements Job {
	
	private static Logger logger = Logger.getLogger(TrafficDataJob.class.getName());
	
	private City city;
	
	public TrafficDataJob() {
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Start TrafficDataJob");
		JobDataMap data = context.getJobDetail().getJobDataMap();
        this.city = City.getCity(data.getInt(ParkingSpacesJob.CITY_PARAM));
        
        logger.info("Execute TrafficDataJob for city: " + this.city.name());
        
        try {
        	TrafficDataCollector.collectTrafficDataForCity(this.city);
        } catch (Exception e){
        	logger.error(e.getMessage(), e);
        }
		
		logger.info("End TrafficDataJob for city: " + this.city.name());
			
	}
}
