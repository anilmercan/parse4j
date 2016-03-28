package remote.parse4j.callback;

import remote.parse4j.ParseException;

public abstract class ParseCallback<T> {
	
	abstract void internalDone(T paramT, ParseException parseException);
	
}
