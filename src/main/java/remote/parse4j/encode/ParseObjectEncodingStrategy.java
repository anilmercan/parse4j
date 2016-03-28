package remote.parse4j.encode;

import org.json.JSONObject;
import remote.parse4j.ParseObject;

public interface ParseObjectEncodingStrategy {
	
	public abstract JSONObject encodeRelatedObject(ParseObject parseObject);

}
