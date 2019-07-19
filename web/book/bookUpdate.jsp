<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../menu.jsp" %>

<form action="/book/update" method="post">
<table border="0" align="center" width="350">
	<tr>
		<td>도서코드</td>
		<td><input type="text" name="isbn" value=<%=request.getParameter("isbn") %>></td>
	</tr>
	<tr>
		<td>책이름</td>
		<td><input type="text" name="title" value=<%=request.getParameter("title") %>></td>
	</tr>
	<tr>
		<td>저자</td>
		<td><input type="text" name="author" value=<%=request.getParameter("author") %>></td>
	</tr>
	<tr>
		<td>출판사</td>
		<td><input type="text" name="company" value=<%=request.getParameter("company") %>></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price" value=<%=request.getParameter("price") %>></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="추가">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
</body>
</html>