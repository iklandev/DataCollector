package here.traffic.flow.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import data.collector.parking.spaces.City;

public class HereMapService {
	
	private static final String APP_ID="5hJ1qPnfkgHNpIKwRICC";
	
	private static final String APP_CODE="_Asu_NBlxliiNWiXFC43kg";
	
	private static final String API_URL="https://traffic.cit.api.here.com/traffic/6.1/flow.json";
	
	private HereMapCityProx prox;
	
	public HereMapService(City city) {
		switch (city) {
		case Pittsburgh:
			this.prox=HereMapCityProx.Pittsburgh;
			break;
		case Madison:
			this.prox=HereMapCityProx.Madison;
			break;
		case Asheville:
			this.prox=HereMapCityProx.Asheville;
			break;
		case AnnArbor:
			this.prox=HereMapCityProx.AnnArbor;
			break;
		case Seattle:
			this.prox=HereMapCityProx.Seattle;
			break;
		case SantaBarbara:
			this.prox=HereMapCityProx.SantaBarbara;
			break;
		case Winchester:
			this.prox=HereMapCityProx.Winchester;
			break;
		case SantaMonica:
			this.prox=HereMapCityProx.SantaMonica;
			break;
		default:
			throw new IllegalArgumentException("City not found");
		}

	}
	
	private String createURL () {
		
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(API_URL);
		urlBuilder.append("?app_id="+APP_ID);
		urlBuilder.append("&app_code="+APP_CODE);
		urlBuilder.append("&prox="+prox.getLatitude());
		urlBuilder.append(","+prox.getLongitude());
		urlBuilder.append(","+prox.getRadius());
		urlBuilder.append("&responseattributes=sh,fc");
		
		return urlBuilder.toString();
	}
	
	public String executeService() throws MalformedURLException, IOException {
		
		String jsonString = IOUtils.toString(new URL(createURL()), Charset.forName("UTF-8"));
		
		return jsonString;
		//Gson g = new Gson(); 
		//HereTrafficML hereTrafficML = g.fromJson(jsonString, HereTrafficML.class);
	}

}
