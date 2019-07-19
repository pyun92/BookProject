<%@page import="dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../menu.jsp" %>

<form action="" method="post">
<h2>도서전체확인</h2>
<table>
	<tr>
		<td>도서코드</td>
		<td>책이름</td>
		<td>저자</td>
		<td>출판사</td>
		<td>가격</td>
		<td>삭제</td>
	</tr>
<%
	ArrayList<BookDTO> list=(ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO bt:list){
%>
	<tr>
		<td>
		<form action="/book/book/bookUpdate.jsp" method="post">
			<a href="javascript:;" onclick="parentNode.submit();"><%=bt.getIsbn()%></a>
			<input type="hidden" name="isbn" value=<%=bt.getIsbn() %>>
			<input type="hidden" name="title" value=<%=bt.getTitle() %>>
			<input type="hidden" name="author" value=<%=bt.getAuthor() %>>
			<input type="hidden" name="company" value=<%=bt.getCompany() %>>
			<input type="hidden" name="price" value=<%=bt.getPrice() %>>
		</form>
		</td>
		<td><%=bt.getTitle() %></td>
		<td><%=bt.getAuthor()%></td>
		<td><%=bt.getCompany() %></td>
		<td><%=bt.getPrice() %></td>
		<td>
		<form action="/book/delete" method="post">
			<input type="hidden" name="isbn" value="<%=bt.getIsbn()%>">
			<input type="submit" value="삭제">
		</form></td>
	</tr>
<%
		}
%>
</table>
</form>
</body>
</html>