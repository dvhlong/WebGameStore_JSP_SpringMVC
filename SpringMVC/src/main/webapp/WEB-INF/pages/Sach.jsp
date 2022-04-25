<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC -HelloWorld</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body style="background-color:#15477B;">
	<fmt:requestEncoding value="UTF-8" />
    <h1 style="color:white;">${test4}</h1>
    <p style="color:white;">Tìm tên sách/giá : </p>
    <c:if test="${requestScope.tb!=null }">
		  <script>alert('Ko tìm thấy');</script>
	</c:if>
    <form action="searchSach" method="post">
    	<p style="color:white;">Chọn tìm kiếm: 
    		<select style="color:black;" name="chon" id="cars">
    			<option value="tensach">Tên Sách</option>
    			<option value="gia">Giá</option>
  </select></p>
    	<table>
    		<tr>
    			<td><input name="key" type="text"></td>
    			<td><button type="submit" name="searchbutton"><i class="fas fa-search"></i></button></td>
    		</tr>
    	</table>
    </form>    
    <c:if test="${requestScope.dssach!=null}">
    <p style="color:white;">Số mẫu tin tìm được: ${requestScope.dssach.size()}</p>
    <table align="center" class="table table-hover" style="color:white;width:80%" >
    <tr>
    	<th>Mã sách</th>
    	<th>Tên sách</th>
    	<th>Tác giả</th>
    	<th>Giá</th>
    	<th>Số lượng</th>
    	<th>Thành tiền</th>
    	<th>Mức</th>
    </tr>
    	<c:forEach items="${requestScope.dssach}" var="sach" >
    		<tr>
    			<td>${sach.masach}</td>
    			<td>${sach.tensach}</td>
    			<td>${sach.tacgia}</td>
    			<td>${sach.gia}</td>
    			<td>${sach.soluong}</td>
    			<td>${sach.thanhtien()}</td>
    			<td>${sach.Muc()}</td>
    		</tr>
    	</c:forEach>
   	</table>
    </c:if>
   
</body>
</html>