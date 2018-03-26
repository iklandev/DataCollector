package data.collector.main;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public class JobTrigger {
	
	private JobDetail job;
	
	private Trigger trigger;
	
	public JobTrigger (JobDetail job, Trigger trigger){
		this.job = job;
		this.trigger = trigger;
	}

	public JobDetail getJob() {
		return job;
	}

	public Trigger getTrigger() {
		return trigger;
	}
}
