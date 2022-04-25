<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<style>

</style>
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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">    
      <li>
      	<a href="showAdmin">Home</a>
      </li>
      <li>
      	<c:choose>
      		<c:when test="${sessionScope.adun==null}">
      			<a href="#" data-toggle="modal" data-target="#myModallogin">Manage Game</a>
      		</c:when>
      		<c:otherwise>
      			<a href="manageGame">Manage Game</a>
      		</c:otherwise>
      	</c:choose>
      </li>
      <li>
      	<c:choose>
      		<c:when test="${sessionScope.adun==null}">
      			<a href="#" data-toggle="modal" data-target="#myModallogin">Manage Category</a>
      		</c:when>
      		<c:otherwise>
      			<a href="manageCategory">Manage Category</a>
      		</c:otherwise>
      	</c:choose>
      </li>
      <li>
      	<c:choose>
      		<c:when test="${sessionScope.adun==null}">
      			<a href="#" data-toggle="modal" data-target="#myModallogin">Manage Code</a>
      		</c:when>
      		<c:otherwise>
      			<a href="manageCode">Manage Code</a>
      		</c:otherwise>
      	</c:choose>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <!-- dung JSTL -->
      <li>
      <c:choose>
         <c:when test="${sessionScope.adun!=null }">
         <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome, ${sessionScope.adun}
        	<span class="caret"></span></a>
        		<ul class="dropdown-menu">
          			 <li><a href="adminLogout">Logout</a></li>
        		</ul>
      	 </li>
        </c:when>
          <c:otherwise>
                 <li><a href="#" data-toggle="modal" data-target="#myModallogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		           <c:if test="${sessionScope.tbad!=null }">
		           		<script>alert("${sessionScope.tbad}");</script>
		           </c:if>
  	      </c:otherwise>
        </c:choose> 
    </ul>
  </div>
</nav>
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModallogin" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="adminLogin" method=post>
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login</h4>
        </div>
        <div class="modal-body">
        <table style="color:white;">
        <tr>
        <td><b><label >Username:</label></b></td>
    	<td><input type="text" name="txtun" style="color:black;"></td>
    	</tr>
    	<tr>
    	<td><b><label>Pasword:</label></b></td>
    	<td><input type="password" name="txtpw" style="color:black;"><br></td>
    	<tr>
    	</table>
    	<c:if test="${sessionScope.showcapt >= 3}">
    		<img src="simpleCaptcha.jpg"/><br>
    		<input type="text" name="answer" style="color:black;"/><br>
    	</c:if>
    	<a href="#" data-toggle="modal" data-target="#myModalsignup" style="color:#14CFEC;" data-dismiss="modal"><p align="right"> Don't have account ? Create new one here</p></a>
        </div>
        <div class="modal-footer">
        	<input type="submit" name="button" value="Login" class="btn btn-default"><hr>
        </div>
      </div>
      </form>
    </div>
  </div>
  <div class="modal fade" id="myModalsignup" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="adminSignup" method=post>
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Sign Up</h4>
        </div>
        <div class="modal-body">
    	<table style="color:white;">
    		 <tr style="height:40px">
                                <td> Username :</td>
                                <td>
                                    <input id="newun" name="newun" type="text" value="" style="color:black;">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>  Password :</td>
                                <td>
                                    <input id="newpass" name="newpass" type="password" style="color:black;">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>Retype Password: </td>
                                <td>
                                    <input id="newrepass" name="newrepass" type="password" style="color:black;">
                                </td>
                            </tr>
    	</table>
        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-default" value="Register" name="rbutton">
        </div>
      </div>
      </form>
    </div>
  </div>
   <div class="modal fade" id="myModaladdcode" role="dialog">
    <div class="modal-dialog">
    <form action="addCode" method="post">
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add code</h4>
        </div>
         <div class="modal-body">
    	<table style="color:white;">
    		<tr>
    			<td><b><label>Game: </label></b></td>
               <td><select name="gid" style="color:black;">
    			<c:forEach items="${glist}" var="g">
				<option value="${g.gid}"><c:out value="${g.gname}"/></option>
				</c:forEach>
    			</select><br>
    			</td>
    		<tr>
    		<tr>
    			<td><b><label>No Limit: </label></b></td>
               <td><select name="nolimit" style="color:black;">
				<option value="1">Yes</option>
				<option value="0">No</option>
    			</select><br>
    			</td>
    		<tr>
    	</table>
        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-default" value="Add" name="rbutton">
        </div>
       </div>
      </form>
   </div>
   </div>
</div>
<div width="1000" style="color:#78F025;margin:auto;width:1000"><marquee>Web game store make by Doan Van Hoang Long</marquee></div>
<div width="2000" style="color:white;margin:auto;width:1000">
<h1 style="font-size:40px;text-align:center;font-weight:bold">CODE LIST</h1>
<a href="#" data-toggle="modal" data-target="#myModaladdcode" class="btn btn-danger" style="background-attachment:fixed;position:absolute;right:150px;top:70px">Add new code</a><br>
<table class="table" style="color:white">
	<tr>
		<th style="border: 1px solid white;text-align:center">Code</th>
		<th style="border: 1px solid white;text-align:center">GID</th>
		<th style="border: 1px solid white;text-align:center">No Limit</th>
		<th style="border: 1px solid white;text-align:center">UserID</th>
	</tr>
	<c:forEach items="${clist}" var="c">
		<tr>
		<td style="border: 1px solid white">${c.code}</td>
		<td style="border: 1px solid white">${c.gid}</td>	
		<td style="border: 1px solid white">${c.isNoLimit()}</td>	
		<td style="border: 1px solid white">${c.uid}</td>		
  		<td style="text-align:center;"><a href="deleteCode?code=${c.code}"><button name="butxoa" type="button" style="background-color:red"><i class='fas fa-eraser'></i></button></a></td>	
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>