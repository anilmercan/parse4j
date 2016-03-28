package local.parse4j.operation;

import local.parse4j.ParseObject;
import local.parse4j.encode.ParseObjectEncodingStrategy;
import org.json.JSONException;

public interface ParseFieldOperation {
	
	abstract Object apply(Object oldValue, ParseObject parseObject, String key);
	
	abstract Object encode(ParseObjectEncodingStrategy objectEncoder) throws JSONException;

}
