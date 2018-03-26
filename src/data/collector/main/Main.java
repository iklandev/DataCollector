package data.collector.main;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import data.collector.jobs.ParkingSpacesJob;
import data.collector.jobs.TrafficDataJob;
import data.collector.parking.spaces.City;

public class Main {
	
	public static final String HOME_APP_DIR = "ParkingDataCollector";
	
	public static final String HOME_APP_PARKING_DIR = "ParkingData";
	public static final String HOME_APP_TRAFFIC_DIR = "TrafficData";
	
	private static final int COLLECT_PARKING_SPACES = 1;
	private static final int COLLECT_TRAFFIC_DATA= 2;
	
	
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		
		logger.info("Application is started");
		System.out.println("Application is started");
		try {
			createDirectory ();
			if (Integer.parseInt(args[0]) == COLLECT_PARKING_SPACES) {
				logger.info("COLLECT_PARKING_SPACES");
				System.out.println("COLLECT_PARKING_SPACES");
				scheduleAllParkingSpacesJobs(Integer.parseInt(args[1]));
			} else if (Integer.parseInt(args[0]) == COLLECT_TRAFFIC_DATA) {
				logger.info("COLLECT_TRAFFIC_DATA");
				System.out.println("COLLECT_TRAFFIC_DATA");
				scheduleAllTrafficDataJobs(Integer.parseInt(args[1]));
			} else {
				throw new Exception("Invvalid application arguments");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			System.out.println(e);
		}
		
		
	}
	
	
	private static void scheduleAllTrafficDataJobs(int scheduleSeconds) throws SchedulerException {
		// First we must get a reference to a scheduler
	    SchedulerFactory sf = new StdSchedulerFactory();
	    Scheduler scheduler = sf.getScheduler();
	    
	    JobTrigger jt = null;
	    //Setup for Pittsburgh
	    jt = scheduleTrafficDataJob(City.Pittsburgh, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Madison
	    jt = scheduleTrafficDataJob(City.Madison, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Asheville
	    jt = scheduleTrafficDataJob(City.Asheville, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for AnnArbor
	    jt = scheduleTrafficDataJob(City.AnnArbor, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Seattle
	    jt = scheduleTrafficDataJob(City.Seattle, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for SantaBarbara
	    jt = scheduleTrafficDataJob(City.SantaBarbara, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Winchester
	    jt = scheduleTrafficDataJob(City.Winchester, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for SantaMonica
	    jt = scheduleTrafficDataJob(City.SantaMonica, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    scheduler.start();
	}
	
	private static void scheduleAllParkingSpacesJobs (int scheduleSeconds) throws SchedulerException {
		
		// First we must get a reference to a scheduler
	    SchedulerFactory sf = new StdSchedulerFactory();
	    Scheduler scheduler = sf.getScheduler();
	    
	    JobTrigger jt = null;
	    //Setup for Pittsburgh
	    jt = scheduleParkingSpacesJob(City.Pittsburgh, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Madison
	    jt = scheduleParkingSpacesJob(City.Madison, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Asheville
	    jt = scheduleParkingSpacesJob(City.Asheville, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for AnnArbor
	    jt = scheduleParkingSpacesJob(City.AnnArbor, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Seattle
	    jt = scheduleParkingSpacesJob(City.Seattle, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for SantaBarbara
	    jt = scheduleParkingSpacesJob(City.SantaBarbara, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for Winchester
	    jt = scheduleParkingSpacesJob(City.Winchester, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    //Setup for SantaMonica
	    jt = scheduleParkingSpacesJob(City.SantaMonica, scheduleSeconds);
	    scheduler.scheduleJob(jt.getJob(), jt.getTrigger());
	    
	    scheduler.start();
	}
	
	private static JobTrigger scheduleParkingSpacesJob(City city, int seconds) throws SchedulerException {
		
		String name = city.name();
		String jobName = "job-" + name;
		String groupName = "group-" + name;
		String triggerName = "trigger-" + name;

		// define the job and tie it to our MyJob class
		JobDetail job = newJob(ParkingSpacesJob.class).withIdentity(jobName, groupName).build();

		job.getJobDataMap().put(ParkingSpacesJob.CITY_PARAM, city.getId());
		// Trigger the job to run now, and then repeat every X seconds
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName).startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(seconds).repeatForever()).build();

		return new JobTrigger(job, trigger);
	}
	
	private static JobTrigger scheduleTrafficDataJob(City city, int seconds) throws SchedulerException {
		
		String name = city.name();
		String jobName = "traffic-job-" + name;
		String groupName = "traffic-group-" + name;
		String triggerName = "traffic-trigger-" + name;

		// define the job and tie it to our MyJob class
		JobDetail job = newJob(TrafficDataJob.class).withIdentity(jobName, groupName).build();

		job.getJobDataMap().put(ParkingSpacesJob.CITY_PARAM, city.getId());
		// Trigger the job to run now, and then repeat every X seconds
		Trigger trigger = newTrigger().withIdentity(triggerName, groupName).startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(seconds).repeatForever()).build();

		return new JobTrigger(job, trigger);
	}
	
	private static void createDirectory () throws IOException {
		Path pathParking = Paths.get(System.getProperty("user.home"), HOME_APP_DIR, HOME_APP_PARKING_DIR);
		Path pathTraffic = Paths.get(System.getProperty("user.home"), HOME_APP_DIR, HOME_APP_TRAFFIC_DIR);
		try {
			if (Files.notExists(pathParking)){
				Files.createDirectory(pathParking);
			}
			
			if (Files.notExists(pathTraffic)){
				Files.createDirectory(pathTraffic);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
