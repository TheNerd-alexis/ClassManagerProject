package Model;

import org.json.simple.JSONObject;

public interface AbstractModel {
	public abstract AbstractModel toModel(JSONObject json);
	public abstract JSONObject toJson();
}
