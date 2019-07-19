package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.BookBiz;
import dto.BookDTO;

/**
 * Servlet implementation class InputBookServlet
 */
@WebServlet(name = "INPUT", urlPatterns = { "/input" })
public class InputBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String company=request.getParameter("company");
		int price=Integer.parseInt(request.getParameter("price"));
		BookDTO bk=new BookDTO(isbn,title,author,company,price);
		BookBiz biz=new BookBiz();
		boolean insert=biz.bookInsert(bk);
		if(insert==true) {
			response.sendRedirect("/book/list");
		}else {
			response.sendRedirect("/book/book/bookInput.jsp");
		}
	}

}
