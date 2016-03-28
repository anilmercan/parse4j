package local.parse4j.operation;

import local.parse4j.ParseObject;
import local.parse4j.encode.ParseObjectEncodingStrategy;
import org.json.JSONException;
import org.json.JSONObject;

public class DeleteFieldOperation implements ParseFieldOperation {

	@Override
	public Object apply(Object oldValue, ParseObject paramParseObject, String key) {
		return null;
	}

	@Override
	public Object encode(ParseObjectEncodingStrategy objectEncoder)
			throws JSONException {
		JSONObject output = new JSONObject();
	    output.put("__op", "Delete");
	    return output;
	}

}
