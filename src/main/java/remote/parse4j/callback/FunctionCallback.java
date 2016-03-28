package remote.parse4j.callback;

import remote.parse4j.ParseException;

public abstract class FunctionCallback<T> extends ParseCallback<T> {

    public abstract void done(T result, ParseException parseException);
	
	@Override
	void internalDone(T result, ParseException parseException) {
		done(result, parseException);
	}
	
}
