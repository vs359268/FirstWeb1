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

import com.google.gson.Gson;
import com.hp.dao.Temp;
import com.hp.service.ITempService;
import com.hp.service.impl.TempServiceImpl;

/**
 * @author Administrator
 *
 */
@WebServlet(name = "ChartServlet", urlPatterns = "/ChartServlet")
public class ChartServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6293860408657952738L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ITempService iTempService = new TempServiceImpl();
			Temp temp = iTempService.queryTemp();
			Gson gson = new Gson();
			String json = gson.toJson(temp);
			System.out.println(json);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
