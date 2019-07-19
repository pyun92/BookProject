package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.BookBiz;
import biz.LoginBiz;
import dto.BookDTO;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet(name = "LIST", urlPatterns = { "/list" })
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		BookBiz biz=new BookBiz();
		ArrayList<BookDTO> list=biz.getBookList();
		
		if(list!=null) {
			System.out.println("값을 받아옴");
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("/book/bookList.jsp");
			rd.forward(request, response);
		}
		
	}


}
