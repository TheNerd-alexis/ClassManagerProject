package Service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.DchDAO;
import Model.AbstractModel;
import Model.Dch;

//일일 출첵 작성

public class DchService {

	private Connection connection;
	DchDAO dao = DchDAO.getInstance(connection);

	// 출첵 정보 입력
	public int dch_add(AbstractModel model) {
		Dch dch = (Dch) model;

		if (dch.getMID() == null)
			return 3;
		if (dch.getATTENDDATE() == null)
			return 4;

		return dao.insertDch(dch);
	}
	
	// 일일 출첵 수정
	public int dch_update(AbstractModel model) {
		Dch dch = (Dch) model;
		
		if (dch.getMID() == null)
			return 3;
		if (dch.getATTENDDATE() == null)
			return 4;
		
//		dao.update(새로운 정보(mid, date, 출석여부))
		return dao.updateDch(dch, dch);
	}

	// 출첵 목록 조회
	public List<Dch> getDchList(AbstractModel model, Date startDate, Date endDate) {
		Dch dch = (Dch) model;
		
		return dao.selectDch(dch, startDate, endDate);
	}
	
	

	
	
}
