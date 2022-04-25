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
<body>
	<fmt:requestEncoding value="UTF-8" />
    <h1>${test3}</h1>
    <form action="searchNXB" method="post">
    	<table>
    		<tr>
    			<td><input name="key" type="text"></td>
    			<td><button type="submit" name="searchbutton"><i class="fas fa-search"></i></button></td>
    		</tr>
    	</table>
    </form>
    <table>
    <c:if test="${requestScope.dsnxb!=null}">
    <tr>
    	<th>Mã NXB</th>
    	<th>Tên NXB</th>
    </tr>
    	<c:forEach items="${requestScope.dsnxb}" var="nxb" >
    		<tr>
    			<td>${nxb.manxb}</td>
    			<td>${nxb.tennxb}</td>
    		</tr>
    	</c:forEach>
    </c:if>
    </table>
</body>
</html>