package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.rollback;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.close;

import dto.BookDTO;

public class BookDAO {

	public BookDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<BookDTO> getBookList(){
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		ArrayList<BookDTO> list=null;
		
		try {
			String sql="select * from bookshop";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			list=new ArrayList<BookDTO>();
			
			while(rs.next()) {
				BookDTO book=new BookDTO();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCompany(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(st);
			close(con);
		}

		return list;
	}
	
	public boolean bookInsert(BookDTO bk) {
		Connection con=getConnection();
		PreparedStatement pst=null;
		boolean insert=false;
		try {
			String sql="INSERT INTO BOOKSHOP VALUES(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, bk.getIsbn());
			pst.setString(2, bk.getTitle());
			pst.setString(3, bk.getAuthor());
			pst.setString(4, bk.getCompany());
			pst.setInt(5, bk.getPrice());
			
			int n=pst.executeUpdate();
			
			if(n>0) {
				insert=true;
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pst);
			close(con);
		}

		return insert;
	}

	public boolean bookDelete(String isbn) {
		Connection con=getConnection();
		PreparedStatement pst=null;
		boolean delete=false;
		try {
			String sql="delete from Bookshop where isbn=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, isbn);
			
			int n=pst.executeUpdate();
			
			if(n>0) {
				delete=true;
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pst);
			close(con);
		}

		return delete;
	}

	public boolean bookUpdate(BookDTO dto) {
		Connection con=getConnection();
		PreparedStatement pst=null;
		boolean update=false;
		try {
			String sql="update bookshop set isbn=?,title=?,author=?,company=?,price=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getIsbn());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getAuthor());
			pst.setString(4, dto.getCompany());
			pst.setInt(5, dto.getPrice());
			
			int n=pst.executeUpdate();
			
			if(n>0) {
				update=true;
				commit(con);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pst);
			close(con);
		}

		return update;
	}
}
