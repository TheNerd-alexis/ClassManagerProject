package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class CMResult implements AbstractModel<CMResult>,Serializable {
	private int result = -1;
	private List<AbstractModel> resultList = new ArrayList<AbstractModel>();

	@Override
	public CMResult toModel(JSONObject json) {
		CMResult result = new CMResult();
		result.setResult((int) json.get("result"));
		result.setResultList((List<AbstractModel>) json.get("resultList"));

		return result;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<AbstractModel> getResultList() {
		return resultList;
	}

	public void setResultList(List<AbstractModel> resultList) {
		this.resultList = resultList;
	}

	public void addToResultList(AbstractModel model) {
		this.resultList.add(model);
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("result", this.result);
		json.put("resultList", this.resultList);
		return json;
	}
}