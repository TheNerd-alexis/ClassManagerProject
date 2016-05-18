package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Multi;

public class MultiService {
	static GetDAO dao = GetDAO.getInstance();

	public static CMResult multi_add(AbstractModel model) {
		CMResult result = new CMResult();
		Multi multi = (Multi) model;
		if(multi.getDAY() == null){
			result.setResult(-2);
		}else if(multi.getFCOURSE()==null){
			result.setResult(-3);
		}else if(multi.getFMENU() == null){
			result.setResult(-4);
		}else if(multi.getFTYPE() == null){
			result.setResult(-5);
		}else{
			result.setResult(dao.getMultiDao().insertMulti(multi));
		
		}
		return result;
	}

	public static CMResult multi_refresh(Multi multi) {
		CMResult result = new CMResult();
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();

		for (AbstractModel T : dao.getMultiDao().selectMulti(multi)) {
			resultList.add(T);
		}
		if (resultList.size() < 1)
			result.setResult(-1);
		else {
			result.setResult(1);
			result.setResultList(resultList);
		}
		return result;
	}
}
