package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Result implements AbstractModel{
	int result = -1;

	@Override
	public AbstractModel toModel(JSONObject json){
		Result result = new Result();
		result.result = (int)json.get("result");

		return result;
	}
	@Override
	public JSONObject toJson(){
		JSONObject json = new JSONObject();
		json.put("result",this.result);
		return json;
	}
}
