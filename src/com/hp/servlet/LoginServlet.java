/**
 * 
 */
package com.hp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author аЁамам
 *
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet", loadOnStartup = 0)
public class LoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -293408477717272029L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = req.getParameter("action");
		
		if ("login".equals(action)) {
			PrintWriter out = resp.getWriter();
			try {
				String mobile = req.getParameter("mobile");
				HttpSession session = req.getSession();
				session.setAttribute("mobile", mobile);
				out.write("{\"success\": true}");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				out.write("{\"success\": false}");
			}
			out.flush();
		}
		if ("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.removeAttribute("mobile");
			resp.sendRedirect(req.getContextPath() + "/jsp/index.jsp");
		}
		
	}
}
