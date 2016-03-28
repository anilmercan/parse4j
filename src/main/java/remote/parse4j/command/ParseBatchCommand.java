package remote.parse4j.command;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import remote.parse4j.ParseConstants;

import java.io.IOException;

/**
 * Generate parse batch requesy body and construct the url 
 * @author Nikolay Rusev
 *
 */
public class ParseBatchCommand extends ParseCommand {

	private static Logger LOGGER = LoggerFactory.getLogger(ParseBatchCommand.class);

	public String getUrl(){
		String base = ParseConstants.API_ENDPOINT;
		String version = ParseConstants.API_VERSION;
		return base + "/" +version + "/" + "batch";
	}
	@Override
	public HttpRequestBase getRequest() throws IOException {
		
		HttpPost httppost = new HttpPost(getUrl());
		setupHeaders(httppost, addJson);

		if (data.has("requests")) {
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Sending data: {}", data.getJSONArray("requests"));
			}
			httppost.setEntity(new StringEntity(data.toString(), "UTF8"));
		}
		return httppost;
	}
}
