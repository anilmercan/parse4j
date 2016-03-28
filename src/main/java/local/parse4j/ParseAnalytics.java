package local.parse4j;

import local.parse4j.command.ParsePostCommand;
import local.parse4j.command.ParseResponse;
import local.parse4j.util.ParseEncoder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

public class ParseAnalytics {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ParseAnalytics.class);

	public static void trackAppOpened() {
		trackEvent("AppOpened");
	}

	public static void trackEvent(String name) {
		trackEvent(name, null);
	}

	public static void trackEvent(String name, Map<String, String> dimensions) {

		if ((name == null) || (name.trim().length() == 0)) {
			LOGGER.error("A name for the custom event must be provided.");
			throw new RuntimeException(
					"A name for the custom event must be provided.");
		}

		class TrackEventInBackgroundThread extends Thread {

			private String event;
			private Map<String, String> dimensions;

			public TrackEventInBackgroundThread(String event,
					Map<String, String> dimensions) {
				this.event = event;
				this.dimensions = dimensions;
			}

			public void run() {
				ParsePostCommand command = new ParsePostCommand("events", event);
				JSONObject data = new JSONObject();
				data.put("at", ParseEncoder.encode(new Date(), null));
				if(dimensions != null && dimensions.size() > 0) {
					data.put("dimentions", ParseEncoder.encode(dimensions, null));
				}
				command.setData(data);
				try {
					ParseResponse response = command.perform();
					if (response.isFailed()) {
						throw response.getException();
					}
					else {
						System.out.println("done");
					}
				} catch (ParseException pe) {
					System.out.println(pe);
				}
			}
		}

		TrackEventInBackgroundThread event = new TrackEventInBackgroundThread(
				name, dimensions);
		ParseExecutor.runInBackground(event);

	}

}
