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
    	</tr>
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
    <div class="modal fade" id="myModaladdgame" role="dialog">
    <div class="modal-dialog">
    <form action="addGame" method=post enctype= "multipart/form-data">
      <div class="modal-content" style="background-color:#15477B;color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add game</h4>
        </div>
         <div class="modal-body">
    	<table style="color:white;">
                      <tr>
        <td><b><label >GName:</label></b></td>
    	<td><input type="text" name="gname" style="color:black;" value="N/A"></td>
    	</tr>
    	<tr>
    	<td><b><label>Release Date:</label></b></td>
    	<td><input type="date" name="rdate" style="color:black;" value="2021-01-01"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Develop:</label></b></td>
    	<td><input type="text" name="dev" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Publish:</label></b></td>
    	<td><input type="text" name="pub" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>OS:</label></b></td>
    	<td><input type="text" name="os" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Processor:</label></b></td>
    	<td><input type="text" name="process" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Ram:</label></b></td>
    	<td><input type="text" name="ram" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>GPU:</label></b></td>
    	<td><input type="text" name="gpu" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>DirectX:</label></b></td>
    	<td><input type="number" name="dx" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Storage:</label></b></td>
    	<td><input type="text" name="sto" style="color:black;" value="N/A"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>About:</label></b></td>
    	<td><textarea rows="10" cols="40" name="about" style="color:black">N/A</textarea><br></td>
    	</tr>
    	<tr>
    	<td><b><label>IMG:</label></b></td>
    	<td><input name="img" type="file"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Cost:</label></b></td>
    	<td><input type="number" name="cost" style="color:black;" value="0"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Discount:</label></b></td>
    	<td><input type="number" name="discount" style="color:black;" value="0" min="0" max="100" step="1" onKeyUp="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>CategoryID:</label></b></td>
    	<td><select name="cid" style="color:black;">
    		<c:forEach items="${clist}" var="c">
			<option value="${c.getCategoryID()}"><c:out value="${c.categoryName}"/></option>
			</c:forEach>
    	</select><br></td>
    	</tr>
    	<tr>
    	<td><b><label>IMG Large:</label></b></td>
    	<td><input name="imgl" type="file"><br></td>
    	</tr>
    	<tr>
    	<td><b><label>Game file:</label></b></td>
    	<td><input name="gfile" type="file"><br></td>
    	</tr>
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
<h1 style="font-size:40px;text-align:center;font-weight:bold">GAME LIST</h1>
<a href="#" data-toggle="modal" data-target="#myModaladdgame" class="btn btn-danger" style="background-attachment:fixed;position:absolute;right:150px;top:70px">Add new game</a><br>
<table class="table" style="color:white">
	<tr>
		<th style="border: 1px solid white;text-align:center">GID</th>
		<th style="border: 1px solid white;text-align:center">GName</th>
		<th style="border: 1px solid white;text-align:center">Release Date</th>
		<th style="border: 1px solid white;text-align:center">Develop</th>
		<th style="border: 1px solid white;text-align:center">Publish</th>
		<th style="border: 1px solid white;text-align:center">Cost</th>
	</tr>
	<c:forEach items="${gdtList}" var="g">
	<tr>
		<td style="border: 1px solid white">${g.gid}</td>
		<td style="border: 1px solid white">${g.gname}</td>	
		<td style="border: 1px solid white">${g.releasedate}</td>	
		<td style="border: 1px solid white">${g.develop}</td>	
		<td style="border: 1px solid white">${g.publish}</td>	
		<td style="border: 1px solid white">${g.cost} VND</td>	
		<td style="text-align:center;"><a href="showEditGame?gid=${g.gid}"><button name="butsua" type="button" style="background-color:red"><i class='fas fa-edit'></i></button></a></td>
  		<td style="text-align:center;"><a href="deleteGame?gid=${g.gid}"><button name="butxoa" type="button" style="background-color:red"><i class='fas fa-eraser'></i></button></a></td>	
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>