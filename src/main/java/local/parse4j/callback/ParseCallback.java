package local.parse4j.callback;

import local.parse4j.ParseException;

public abstract class ParseCallback<T> {
	
	abstract void internalDone(T paramT, ParseException parseException);
	
}
