<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HTW Berlin | Room Finder</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Custom core CSS -->
  <link href="/resources/css/navbar_custom.css" rel="stylesheet">
  <link href="/resources/css/position_custom.css" rel="stylesheet">

  <!-- Favicon -->
  <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
  
</head>

<body>
	
	  <!-- Navigation -->
	  <nav class="navbar navbar-expand-lg navbar-dark navbar-custom static-top">
	    <div class="container">
	      <a class="navbar-brand" href="/">HTW Berlin | Room Finder</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	          
	          <li class="nav-item active">
	            <a class="nav-link" href="/search">Search</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="/myList">Meine Liste</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="/account">Mein Profil</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="/logout">LOGOUT</a>
	          </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	
	
	
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			
			<div class="col-lg-12 text-left">
			
				<h1 class="mt-5">SUCHMASCHINE für Free Room</h1>
		        <p class="lead">Bitte fülle die folgenden Felder aus:</p>

			</div>
			
			
			
			
			<!-- Search Form for Free Room START-->
			<div class="col-lg-12 text-left" id="searchFreeRoomForm">

				<form:form action="/search/freeRoom" method="POST" modelAttribute="freeRoomSearchForm">
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Datum* : </span>
						  </div>
						  <form:input path="date" type="date" class="form-control form-control-sm" value="${currentDate}" required="required"/>
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Zeituhr* : </span>
						  </div>
						  		<form:select path="uhr" class="form-control form-control-sm">
								         	<c:forEach var="i" items="${zeituhr}">
								         			<form:option value="${i}">${i}</form:option>								         		
								         	</c:forEach>
							  	</form:select>
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Dauer(hh:mm)* : </span>
						  </div>
						  		<form:select path="dauer" class="form-control form-control-sm">
								         	<c:forEach var="i" items="${dauer}">
								         			<form:option value="${i}">${i}</form:option>								         		
								         	</c:forEach>
							  	</form:select>
					</div>
			
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Raum: </span>
						  </div>
						  <form:input path="room" type="text" class="form-control form-control-sm" placeholder="(optional)" />
					</div>
					
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Ergebnisanzahl* : </span>
						  </div>
						  <form:input path="number" type="number" class="form-control form-control-sm" min="1" max="100" placeholder="von 1 bis 100" required="required" value="15"/>
					</div>
					
					<span class="small">
						*Pflichtfelder
					</span> 
					<br>
					
					<input type="submit" class="btn btn-outline-success" value="SUCHEN">
					
				</form:form>

				
				<div class="col-lg-12 text-center">
				
					<c:if test="${not empty rooms}">
					
						<table class="table table-bordered table-bottom table-top table-responsive-sm">
							<thead>
								<tr>
								  <th scope="col">Datum</th>
								  <th scope="col">Raum</th>
								  <th scope="col">Von</th>
								  <th scope="col">Bis</th>
								  <th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="room" items="${rooms}">
										<tr>
										  <td><fmt:formatDate value="${room.date}" type="date" pattern="dd.MM.yyyy"/></td>
										  <td>${room.roomName}</td>
										  <td><fmt:formatDate value="${room.beginTime}" type="date" pattern="HH:mm"/></td>
										  <td><fmt:formatDate value="${room.endTime}" type="date" pattern="HH:mm"/></td>
										  <td><button type="button" class="btn btn-secondary btn-sm">speichern</button></td>
										</tr>
								</c:forEach>
							</tbody> 
						</table>
				
					</c:if>
					
					<c:if test="${startSearch==false}">
						
						<c:if test="${empty rooms}">
							Nichts gefunden! 
						</c:if>
						
					</c:if>
					
					
					
				</div>
				
	  		</div>	
			<!-- Search Form for Free Room END-->

			
			

		</div>
	</div>
	
	
	
	
	
	
	
	
	
	  <!-- Footer -->
	  <footer class="py-3 bg-dark fixed-bottom">
	    <div class="container">
	      <p class="m-0 text-center text-white">HTW Berlin &copy; Room Finder 2019</p>
	    </div>
	    <!-- /.container -->
	  </footer>
	
	  <!-- Bootstrap core JavaScript -->
	  <script src="/resources/jquery/jquery.slim.min.js"></script>
	  <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>

	
</body>
</html>