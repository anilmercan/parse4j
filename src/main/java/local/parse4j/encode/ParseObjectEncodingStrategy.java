package local.parse4j.encode;

import local.parse4j.ParseObject;
import org.json.JSONObject;

public interface ParseObjectEncodingStrategy {
	
	public abstract JSONObject encodeRelatedObject(ParseObject parseObject);

}
