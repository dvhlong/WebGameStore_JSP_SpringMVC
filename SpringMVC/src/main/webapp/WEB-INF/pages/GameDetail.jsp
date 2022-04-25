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
<c:if test="${sessionScope.status!=null}">
		<script>alert("${sessionScope.status}");</script>
</c:if>
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
	<h1>${gdtbean.gname}</h1>
	<img width="1000" height="300" src="imgGameLarge/${gdtbean.imgLarge}"><br>
	<c:choose>
	<c:when test="${checkbuy==1}">
		<div style="text-align:right">
		<span class="label label-default" style="font-size:15">You own this game</span>
		<c:choose>
			<c:when test="${sessionScope.u==null}">
				<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="button" class="btn btn-success">Install</button></a><br>
			</c:when>
			<c:otherwise>
				<a href="gameFile/${gdtbean.gameFile}" download><button type="button" class="btn btn-success">Install</button></a><br>
			</c:otherwise>
		</c:choose> 
		</div>
	</c:when>
	<c:otherwise>
	<c:choose>
        <c:when test="${gdtbean.discount==0}">
          	<c:choose>
          		<c:when test="${gdtbean.cost==0}">
          			<div style="text-align:right">
          			<span class="label label-default" style="font-size:15">Free To Play</span>
          			<c:choose>
          			<c:when test="${sessionScope.u==null}">
          			<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="button" class="btn btn-success">Install</button></a><br>
          			</c:when>
          			<c:otherwise>
          			<a href="gameFile/${gdtbean.gameFile}" download><button type="button" class="btn btn-success">Install</button></a><br>
          			</c:otherwise>
          			</c:choose>
          			</div>
          		</c:when>
          		<c:otherwise>
          			<div style="text-align:right">
          			<span class="label label-default" style="font-size:15">${gdtbean.cost} VND</span>
          			<c:choose>
          				<c:when test="${sessionScope.u==null}">
          					<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="submit" class="btn btn-success" name="buynow">Buy now</button></a>
          					<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="submit" class="btn btn-warning" name="addcart">Add to cart</button></a><br>
          				</c:when>
          				<c:otherwise>
          					<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&cost=${gdtbean.getFinalCost()}&buynow=1"><button type="submit" class="btn btn-success" name="buynow">Buy now</button></a>
          					<c:choose>
          						<c:when test="${isInCart==1}">
          							<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&remove=1"><button type="submit" class="btn btn-danger" name="removecart">Remove from cart</button></a><br>
          						</c:when>
          						<c:otherwise>
          							<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&gname=${gdtbean.gname}&cost=${gdtbean.getFinalCost()}&add=1"><button type="submit" class="btn btn-warning" name="addcart">Add to cart</button></a><br>
          						</c:otherwise>
          					</c:choose>
          					
          				</c:otherwise>
          			</c:choose>
          			</div>
          		</c:otherwise>
          	</c:choose>
        </c:when>
        <c:otherwise>
        		<div style="text-align:right">
          		<text style="color:#9DB9BF">Discount: </text><text style="color:#42EC14;">${gdtbean.discount}%</text>
          		<span class="label label-default" style="font-size:15"><text style="text-decoration: line-through;">${gdtbean.cost} VND</text>
          			${gdtbean.getFinalCost()} VND</span>
          		<c:choose>
          			<c:when test="${sessionScope.u==null}">
          				<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="submit" class="btn btn-success" name="buynow">Buy now</button></a>
          				<a href="#" data-toggle="modal" data-target="#myModallogin"><button type="submit" class="btn btn-warning" name="addcart">Add to cart</button></a><br>
          			</c:when>
          			<c:otherwise>
          				<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&cost=${gdtbean.getFinalCost()}&buynow=1"><button type="submit" class="btn btn-success" name="buynow">Buy now</button></a>
          				<c:choose>
          						<c:when test="${isInCart==1}">
          							<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&remove=1"><button type="submit" class="btn btn-danger" name="removecart">Remove from cart</button></a><br>
          						</c:when>
          						<c:otherwise>
          							<a href="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}&gname=${gdtbean.gname}&cost=${gdtbean.getFinalCost()}&add=1"><button type="submit" class="btn btn-warning" name="addcart">Add to cart</button></a><br>
          						</c:otherwise>
          					</c:choose>
          			</c:otherwise>
          		</c:choose>
          		</div>
        </c:otherwise>
    </c:choose>
    </c:otherwise>
    </c:choose>
	<h2>ABOUT THIS GAME :</h2>
	<p>${gdtbean.about}</p>
	<text style="color:#9DB9BF">Release date: </text><text>${gdtbean.getReleasedate()}</text><br>
	<text style="color:#9DB9BF">Develop:      </text><text>${gdtbean.develop}</text><br>
	<text style="color:#9DB9BF">Publish:      </text><text>${gdtbean.publish}</text><br>
	<c:choose>
		<c:when test="${rlist==null}">
			<text style="color:#9DB9BF">Star voting: </text><text>N/A</text><br>
		</c:when>
		<c:otherwise>
			<text style="color:#9DB9BF">Star voting: </text><text>${averageStar}</text><br>
		</c:otherwise>
	</c:choose>
	<h2>SYSTEM REQUIREMENTS :</h2>
	<text style="color:#9DB9BF">OS: </text><text>${gdtbean.os}</text><br>
	<text style="color:#9DB9BF">Processor </text><text>${gdtbean.processor}</text><br>
	<text style="color:#9DB9BF">Memory: </text><text>${gdtbean.ram}</text><br>
	<text style="color:#9DB9BF">Graphics Card: </text><text>${gdtbean.gpu}</text><br>
	<text style="color:#9DB9BF">DirectX: </text><text>${gdtbean.directx}</text><br>
	<text style="color:#9DB9BF">Storage: </text><text>${gdtbean.storage}</text><br>
	<h2>REVIEW :</h2>
	<h3>Your review:</h3>
	<c:choose>
		<c:when test="${sessionScope.u==null}">
			<a href="#" data-toggle="modal" data-target="#myModallogin"><button class="btn btn-default">Please login to review</button></a>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pReview==null}">
					<form action="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}" method="post">
						<text style="color:#9DB9BF">Vote star: </text><input type="number" name="txtstar" min="1" max="5" step="1" value="5" style="color:black" onKeyUp="if(this.value>5){this.value='5';}else if(this.value<1){this.value='1';}"><br>
						<textarea rows="10" cols="60" name="txtreview" placeholder="Write your review here" style="color:black"></textarea><br>
						<p><button type="submit" class="btn btn-default" name="addReview">Add your review</button></p>
					</form>
				</c:when>
					
				<c:otherwise>
					<form action="showGameDetail?gid=${gdtbean.gid}&un=${sessionScope.u.un}" method="post">
						<text style="color:#9DB9BF">Vote star: </text><input type="number" name="txtstar" min="1" max="5" step="1" value="${pReview.star}" style="color:black" onKeyUp="if(this.value>5){this.value='5';}else if(this.value<1){this.value='1';}"><br>
						<textarea rows="10" cols="60" name="txtreview" placeholder="Write your review here" style="color:black">${pReview.content}</textarea><br>
						<text><button type="submit" name="updateReview" class="btn btn-default">Update your review</button></text>
						<text><button type="submit" name="deleteReview" class="btn btn-default">Delete your review</button></text><br>
					</form>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<h3>All review: </h3>
	<c:if test="${rlist.size()==0}">
		<text style="color:#9DB9BF">No one review </text>
	</c:if>
	<table style="color:white" width="900">
	<c:forEach items="${rlist}" var="r">
		
			<tr align="top">
				<td valign="top" width="200">${r.un}</td>
				<td>
					<text style="color:#9DB9BF">Posted: </text><text>${r.getRdateFormat()}</text><br>
					<text style="color:#9DB9BF">Vote: </text><text>${r.star} Stars</text><br>
					<p>${r.getFormatContent()}</p>
				</td>
			</tr>
			<tr></tr>
	</c:forEach>
	</table>
	<br><br><br><br><br>
</div>
</body>
</html>