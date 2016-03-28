package local.parse4j.callback;

import local.parse4j.ParseException;

public abstract class RequestPasswordResetCallback extends ParseCallback<Void> {

	public abstract void done(ParseException parseException);

	final void internalDone(Void paramVoid, ParseException parseException) {
		done(parseException);
	}

}
