package remote.parse4j.callback;

import remote.parse4j.ParseException;
import remote.parse4j.ParseGeoPoint;

public abstract class LocationCallback extends ParseCallback<ParseGeoPoint> {

	abstract void done(ParseGeoPoint parseGeoPoint, ParseException parseException);

	@Override
	void internalDone(ParseGeoPoint parseGeoPoint, ParseException parseException) {
		done(parseGeoPoint, parseException);
	}
	
}
