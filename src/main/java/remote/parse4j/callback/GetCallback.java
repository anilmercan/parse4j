package remote.parse4j.callback;

import remote.parse4j.ParseException;
import remote.parse4j.ParseObject;

public abstract class GetCallback<T extends ParseObject> extends ParseCallback<T> {

    public abstract void done(T t, ParseException parseException);
	
	@Override
	void internalDone(T t, ParseException parseException) {
		done(t, parseException);
	}
	
}
