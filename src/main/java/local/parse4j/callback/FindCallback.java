package local.parse4j.callback;

import local.parse4j.ParseException;
import local.parse4j.ParseObject;

import java.util.List;

public abstract class FindCallback<T extends ParseObject> extends ParseCallback<List<T>> {

	public abstract void done(List<T> list, ParseException parseException);
	
	@Override
	void internalDone(List<T> list, ParseException parseException) {
		done(list, parseException);
	}
	
}
