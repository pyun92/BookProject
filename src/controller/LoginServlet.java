package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.LoginBiz;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LOGIN", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		LoginBiz biz=new LoginBiz();
		boolean login=biz.getLoginUser(id, pwd);
		
		if(login==true) {
			HttpSession session=request.getSession();
			session.setAttribute("login", id);
			response.sendRedirect("/book/login/loginOK.jsp");
		}else {
			response.sendRedirect("/book/login/fail.jsp");
		}
	}

}
