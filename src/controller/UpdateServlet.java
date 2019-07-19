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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("UTF-8");
	
		BookBiz biz=new BookBiz();
		BookDTO dto=
				new BookDTO(request.getParameter("isbn"),
						request.getParameter("title"), request.getParameter("author"),
						request.getParameter("company"), Integer.parseInt(request.getParameter("price")));
		boolean delete=biz.bookUpdate(dto);
		
		if(delete==true) {
			System.out.println("수정되었습니다.");
			response.sendRedirect("/book/list");
		}
	}

}
