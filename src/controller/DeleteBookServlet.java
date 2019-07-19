package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.BookBiz;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet(name = "Delete", urlPatterns = { "/delete" })
public class DeleteBookServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String isbn=request.getParameter("isbn");
		BookBiz biz=new BookBiz();
		boolean delete=biz.bookDelete(isbn);
		if(delete==true) {
			System.out.println("삭제되었습니다.");
			response.sendRedirect("/book/list");
		}
	}

}
