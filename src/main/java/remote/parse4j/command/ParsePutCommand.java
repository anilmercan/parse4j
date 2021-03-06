package remote.parse4j.command;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import remote.parse4j.Parse;

import java.io.IOException;

public class ParsePutCommand extends ParseCommand {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ParsePutCommand.class);
	
	private String endPoint;
	private String objectId;

	public ParsePutCommand(String endPoint, String objectId) {
		this.endPoint = endPoint;
		this.objectId = objectId;
	}
	
	public ParsePutCommand(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public HttpRequestBase getRequest() throws IOException {
		
		HttpPut httpput = new HttpPut(getUrl());
		setupHeaders(httpput, true);
		
		if (data != null) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Sending data: {}", data.getJSONObject("data"));
			}
			httpput.setEntity(new StringEntity(data.getJSONObject("data").toString(), "UTF8"));
		}		
		return httpput;
	}
	
	protected String getUrl() {
		String url = Parse.getParseAPIUrl(endPoint) + (objectId != null ? "/" + objectId : "");
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Request URL: {}", url);
		}
		
		return url;
	}

}
