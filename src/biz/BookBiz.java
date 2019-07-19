package biz;

import java.util.ArrayList;

import dao.BookDAO;
import dto.BookDTO;

public class BookBiz {

	public BookBiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<BookDTO> getBookList(){
		BookDAO dao=new BookDAO();
		return dao.getBookList();
	}
	
	public boolean bookInsert(BookDTO bk) {
		BookDAO dao=new BookDAO();
		return dao.bookInsert(bk);
	}

	public boolean bookDelete(String isbn) {
		BookDAO dao=new BookDAO();
		return dao.bookDelete(isbn);
	}

	public boolean bookUpdate(BookDTO dto) {
		BookDAO dao=new BookDAO();
		return dao.bookUpdate(dto);
	}
}
