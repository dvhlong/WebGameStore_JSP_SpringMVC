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
      	<a href="showGameList">Home</a>
      </li>
      <li>
      	<c:choose>
      		<c:when test="${sessionScope.u==null}">
      			<a href="#" data-toggle="modal" data-target="#myModallogin">Cart</a>
      		</c:when>
      		<c:otherwise>
      			<a href="showCart">Cart</a>
      		</c:otherwise>
      	</c:choose>
      </li>
    </ul>
      <c:choose>
      	<c:when test="${sessionScope.u==null}">
      	<a href="#" data-toggle="modal" data-target="#myModallogin"><button class="btn btn-danger navbar-btn">Activate Product</button></a>
      	</c:when>
      	<c:otherwise>
      	<a href="#" data-toggle="modal" data-target="#myModalactivate"><button class="btn btn-danger navbar-btn">Activate Product</button></a>
      	</c:otherwise>
      </c:choose>
       	<form class="navbar-form navbar-left" action="showGameList" method="post">
  			<div class="input-group">
    			<input type="text" class="form-control" name="key" placeholder="Search">
    			<div class="input-group-btn">
      				<button class="form-control" type="submit">
        				<i class="glyphicon glyphicon-search"></i>
      				</button>
    			</div>
  			</div>
		</form>
    <ul class="nav navbar-nav navbar-right">
      <!-- dung JSTL -->
      <li>
      <c:choose>
         <c:when test="${sessionScope.u!=null }">
         <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome, ${sessionScope.u.un}
        	<span class="caret"></span></a>
        		<ul class="dropdown-menu">
         			 <li><a href="#" data-toggle="modal" data-target="#myModalchangePass">Change Password</a></li>
          			 <li><a href="purchaseHistory">Purchases History</a></li>
          			 <li><a href="userLogout">Logout</a></li>
        		</ul>
      	 </li>
        </c:when>
          <c:otherwise>
                 <li><a href="#" data-toggle="modal" data-target="#myModallogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		           <c:if test="${sessionScope.tb!=null }">
		           		<script>alert("${sessionScope.tb}");</script>
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
      <form action="userLogin" method=post>
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
      <form action="userSignup" method=post>
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
                                <td> Email :</td>
                                <td>
                                    <input id="newemail" name="newemail" type="text" value="" style="color:black;">
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
  <div class="modal fade" id="myModalactivate" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="activateGame" method=post>
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Product Activation</h4>
        </div>
        <div class="modal-body">
        <table style="color:white;">
        <tr>
        <td><b><label >Product Code: </label></b></td>
    	<td><input type="text" name="code" style="color:black;"></td>
    	</tr>
    	</table>
        </div>
        <div class="modal-footer">
        	<input type="submit" name="button" value="activate" class="btn btn-default"><hr>
        </div>
      </div>
      </form>
    </div>
  </div>
    <div class="modal fade" id="myModalchangePass" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="userChangePass?un=${sessionScope.u.un}&pass=${sessionScope.u.pass}" method=post>
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Change Password</h4>
        </div>
        <div class="modal-body">
    	<table style="color:white;">
    		 <tr style="height:40px">
                                <td> Old password :</td>
                                <td>
                                    <input id="oldpass" name="oldpass" type="password" value="" style="color:black;">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>New Password :</td>
                                <td>
                                    <input id="newpass" name="newpass" type="password" style="color:black;">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>Retype New Password: </td>
                                <td>
                                    <input id="newrepass" name="newrepass" type="password" style="color:black;">
                                </td>
                            </tr>
    	</table>
        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-default" value="Change" name="rbutton">
        </div>
      </div>
      </form>
    </div>
  </div>
</div>
<div width="1000" style="color:#78F025;margin:auto;width:1000"><marquee>Web game store make by Doan Van Hoang Long</marquee></div>
<p style="text-align:center"><img width="1000" height="350" src="gamestore.jpg"></p><br>
<div width="1000" style="color:white;margin:auto;width:1000">
<table width="900" align="center" style="color:white" class="table">
	<tr>
	<th>Game name</th>
	<th>Purchase time</th>
	<th>Game cost</th>
	<tr>
	<c:forEach items="${hlist}" var="h">
		<tr>
		<td>${h.gname}</td>
		<td>${h.getFormatTime()}</td>
		<td>
		<c:choose>
			<c:when test="${h.cost==0}">
				Activated by code
			</c:when>
			<c:otherwise>
				${h.cost} VND
			</c:otherwise>
		</c:choose>
		</td>
		</tr>
	</c:forEach>
</table>
<p style="text-align:right"><text style="color:#9DB9BF">Total Purchase Cost: </text><text>${totalPurchaseCost} VND</text><br></p>
</div>
</body>
</html>