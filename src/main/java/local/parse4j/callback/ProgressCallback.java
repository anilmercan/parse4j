package local.parse4j.callback;

import local.parse4j.ParseException;

public abstract class ProgressCallback extends ParseCallback<Integer> {
	
	public abstract void done(Integer percentDone);
	
	@Override
	void internalDone(Integer paramT, ParseException parseException) {
		done(paramT);
	}

}
