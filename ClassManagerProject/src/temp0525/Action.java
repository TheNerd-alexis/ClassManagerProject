package temp0525;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;

}
