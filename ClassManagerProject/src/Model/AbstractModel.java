package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;

public interface AbstractModel<T extends AbstractModel> extends Serializable {
	public abstract T toModel(JSONObject json);
	public abstract JSONObject toJson();
	public abstract String getID();
	public abstract T setID(String id);
}
