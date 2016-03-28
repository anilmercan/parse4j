package remote.parse4j.operation;

import org.json.JSONException;
import org.json.JSONObject;
import remote.parse4j.ParseObject;
import remote.parse4j.encode.ParseObjectEncodingStrategy;
import remote.parse4j.util.ParseEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class AddUniqueOperation implements ParseFieldOperation {

	protected LinkedHashSet<Object> objects = new LinkedHashSet<Object>();

	public AddUniqueOperation(Collection<?> coll) {
		this.objects.addAll(coll);
	}

	public AddUniqueOperation(Object o) {
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
		output.put("__op", "AddUnique");
		output.put("objects", ParseEncoder.encode(new ArrayList<Object>(this.objects), objectEncoder));
		return output;
	}

}
