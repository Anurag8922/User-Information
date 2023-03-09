package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			pw.println("Session expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} else {
			UserBean ub = (UserBean) hs.getAttribute("ubean");
			ub.setAddr(req.getParameter("addr"));
			ub.setmId(req.getParameter("mid"));
			ub.setPhNo(Long.parseLong(req.getParameter("phno")));
			pw.println("Page of User : " + ub.getfName() + "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			int k = new UpdateDAO().update(ub);
			if (k > 0) {
				pw.println("<br>Profile updated Successfully...");
			}
		}
	}
}