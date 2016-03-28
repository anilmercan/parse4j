package local.parse4j.operation;

import local.parse4j.ParseObject;
import local.parse4j.encode.ParseObjectEncodingStrategy;
import local.parse4j.util.ParseEncoder;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public class AddOperation implements ParseFieldOperation {

	protected final ArrayList<Object> objects = new ArrayList<Object>();

	public AddOperation(Collection<?> coll) {
		this.objects.addAll(coll);
	}

	public AddOperation(Object o) {
		this.objects.add(o);
	}

	@Override
	public Object apply(Object oldValue, ParseObject parseObject, String key) {
		throw new IllegalArgumentException("not implemented!");
	}

	@Override
	public Object encode(ParseObjectEncodingStrategy objectEncoder)
			throws JSONException {
	    JSONObject output = new JSONObject();
	    output.put("__op", "Add");
	    output.put("objects", ParseEncoder.encode(this.objects, objectEncoder));
	    return output;
	}

}
