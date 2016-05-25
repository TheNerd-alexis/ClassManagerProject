package temp0525;

import action.Action;
import action.BoardCheckPassAction;
import action.BoardCheckPassFormAction;
import action.BoardDeleteAction;
import action.BoardListAction;
import action.BoardUpdateAction;
import action.BoardUpdateFormAction;
import action.BoardViewAction;
import action.BoardWriteAction;
import action.BoardWriteFormAction;

public class ActionFactory {
	
	// 싱글턴 시작
	private static ActionFactory instance;
	private ActionFactory() {
		
	}
	
	public static ActionFactory getInstance() {
		if(instance == null)
			instance = new ActionFactory(); // 생성자를 만든 의미는 크게 없다고 함
		return instance;
	}
	
	// 싱글턴 끝
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("Action Factory: " + command);
		
		if(command.equals("board_list"))
			action = new BoardListAction();
		
		else if(command.equals("board_write_form"))
			action = new BoardWriteFormAction();
		
		else if(command.equals("board_write"))
			action = new BoardWriteAction();
		
		else if(command.equals("board_view"))
			action = new BoardViewAction();
		
		else if(command.equals("board_check_pass_form"))
			action = new BoardCheckPassFormAction();
		
		else if(command.equals("board_check_pass"))
			action = new BoardCheckPassAction();
		
		else if(command.equals("board_update_form"))
			action = new BoardUpdateFormAction();
		
		else if(command.equals("board_update"))
			action = new BoardUpdateAction();
		
		else if(command.equals("board_delete"))
			action = new BoardDeleteAction();
		
		return action;
	}

}
