package local.parse4j.callback;

import local.parse4j.ParseException;
import local.parse4j.ParseUser;

public abstract class LoginCallback extends ParseCallback<ParseUser> {

	abstract void done(ParseUser parseUser, ParseException parseException);
	
	@Override
	void internalDone(ParseUser parseUser, ParseException parseException) {
		done(parseUser, parseException);
	}
	
}
