package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println(" in init");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("in destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doGet");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost");
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd").trim();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(username.equals("admin")&& password.equals("admin123"))
		{
		 	pw.print("<html>"
		 			+ "<body>"+"<h2>"
		 			+ "Welcome " +username+"!"
		 			+ "<br/>"
		 			+"Today's date: "+LocalDate.now()
		 			+"</h2>"
		 			+"</body>"
		 			+"</html>");
		}else{
			pw.print("<html><body>"+"<h2>"
		 			+ "enter correct username and password!<br/>"
					+ "<a href='index.html'>go to login page </a>"
				    + "</h2>"
		 			+ "</body>"
		 			+ "</html>");
			
		}
		
		
	}

}
