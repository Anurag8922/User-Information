package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServelet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			pw.println("<h2>Session Expired...</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} else {
			UserBean ub = (UserBean) hs.getAttribute("ubean");
			ub.setRollno(Long.parseLong(req.getParameter("rollno")));
            
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			int k = new DeleteDAO().delete(ub);
			if (k > 0) {
				pw.println("<br>Record is Deleted Successfully...");
			}
		}
	}
}
