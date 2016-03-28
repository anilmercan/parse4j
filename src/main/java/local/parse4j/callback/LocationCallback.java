package local.parse4j.callback;

import local.parse4j.ParseException;
import local.parse4j.ParseGeoPoint;

public abstract class LocationCallback extends ParseCallback<ParseGeoPoint> {

	abstract void done(ParseGeoPoint parseGeoPoint, ParseException parseException);

	@Override
	void internalDone(ParseGeoPoint parseGeoPoint, ParseException parseException) {
		done(parseGeoPoint, parseException);
	}
	
}
