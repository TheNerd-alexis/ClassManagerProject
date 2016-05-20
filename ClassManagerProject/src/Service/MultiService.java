package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Multi;

public class MultiService {
	static GetDAO dao = GetDAO.getInstance();
	
	/*
	 * Null Type:
	 * -100: DAY(PK)
	 * -101: FCOURSE(PK)
	 * -102: FTYPE
	 * -103: FMENU
	 */

	public static CMResult multi_add(AbstractModel model) {
		Multi multi = (Multi) model;
		CMResult result = new CMResult();
		
		if (multi.getDAY() == null)
			return result.setResult(-100);
		if (multi.getFCOURSE()==null)
			return result.setResult(-101);
		if (multi.getFTYPE() == null)
			return result.setResult(-102);
		if (multi.getFMENU() == null)
			return result.setResult(-103);
			
		return result.setResult(dao.getMultiDao().insertMulti(multi));
		
	}

	public static CMResult multi_refresh(AbstractModel model) {
		Multi multi = (Multi) model;
		CMResult result = new CMResult();
		
		List<Multi> multiList = dao.getMultiDao().selectMulti(multi);

		if (multiList.size() < 1)
			return result.setResult(-2);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for (AbstractModel T : dao.getMultiDao().selectMulti(multi)) {
			resultList.add(T);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}
}
