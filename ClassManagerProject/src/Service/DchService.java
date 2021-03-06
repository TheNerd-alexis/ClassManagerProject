package Service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DAO.DchDAO;
import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Dch;

//일일 출첵 작성

public class DchService {

	static GetDAO dao = GetDAO.getInstance();

	/*
	 * Null Type: -100: MID 외래키(MID) -101: ATTENDDATE -102: ATTENDANCE -103:
	 * startDate -104: endDate
	 */

	// 출첵 정보 입력
	/**
	 * 출석체크 추가 서비스
	 * 
	 * @param model
	 *            = Dch
	 * @return 1: 출석체크 추가 성공<br>
	 *         0: 출석체크 추가 실패(INSERT 실패)<br>
	 *         -1: SQL Exception<br>
	 *         -2: List<Dch> 조회 실패<br>
	 *         -100: MID - NULL<br>
	 */
	public static CMResult dch_add(AbstractModel model) {
		Dch dch = (Dch) model;
		CMResult result = new CMResult();

		if (dch.getMID() == null)
			return result.setResult(-100);

		List<Dch> dchList = dao.getDchDao().selectDch(dch);
		if (dchList.size() < 1)
			return result.setResult(dao.getDchDao().insertDch(dch));
		return result.setResult(dao.getDchDao().updateDch(dch,dch));
	}

	// 일일 출첵 수정
	/**
	 * 출석체크 수정 서비스
	 * 
	 * @param model
	 *            = Dch
	 * @return 1: 출석체크 수정 성공<br>
	 *         0: 출석체크 수정 실패(UPDATE 실패)<br>
	 *         -1: SQL Exception<br>
	 *         -2: List<Dch> 조회 실패<br>
	 *         -100: MID - NULL<br>
	 *         -101: ATTENDATE - NULL<br>
	 *         -102: ATTENDANCE - NULL
	 */
	public static CMResult dch_update(AbstractModel newModel, AbstractModel beforeModel) {
		Dch newDch = (Dch) newModel;
		Dch beforeDch = (Dch) beforeModel;
		CMResult result = new CMResult();

		if (newDch.getMID() == null)
			return result.setResult(-100);

		if (newDch.getATTENDDATE() == null)
			return result.setResult(-101);

		if (newDch.getATTENDANCE() == null)
			return result.setResult(-102);

		return result.setResult(dao.getDchDao().updateDch(newDch, beforeDch));
	}

	// 출첵 목록 조회
	/**
	 * 출석체크 목록 조회 서비스
	 * 
	 * @param model
	 *            = Dch
	 * @return 1: 출석체크 목록 조회 성공<br>
	 *         0: 출석체크 목록 조회 실패(SELECT(Date) 실패)<br>
	 *         -1: SQL Exception<br>
	 *         -2: List<Dch> 조회 실패<br>
	 *         -103: startDate - NULL<br>
	 *         -104: endDate - NULL
	 */
	public static CMResult getDchList(AbstractModel model, Date startDate, Date endDate) {
		Dch dch = (Dch) model;
		CMResult result = new CMResult();

		if (startDate == null)
			return result.setResult(-103);

		if (endDate == null)
			return result.setResult(-104);

		List<Dch> dchList = dao.getDchDao().selectDch(dch, startDate, endDate);
		if (dchList.size() < 1)
			return result.setResult(-2);

		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for (Dch d : dchList) {
			resultList.add(d);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}
}
