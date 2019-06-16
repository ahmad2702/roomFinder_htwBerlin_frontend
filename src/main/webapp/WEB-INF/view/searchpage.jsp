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
	            <a class="nav-link" href="/search">Finder</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">Meine Reservierungen</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">Profile</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="#">LOGOUT</a>
	          </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	
	
	
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-left">
		  
		        <h1 class="mt-5">SUCHMASCHINE</h1>
		        <p class="lead">Bitte fülle die folgenden Felder aus:</p>
		         
				
				
				<form:form action="/search" method="POST" modelAttribute="eventSearchForm">
					
					<div class="input-group input-group-sm mb-3">
					  <div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Option:</label>
					  </div>
					  <select class="custom-select" id="inputGroupSelect01">
						<option value="1">Ich suche einen Modul</option>
						<option value="2">Ich suche einen freien Raum</option>
					  </select>
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Title (z.B. Mathematik): </span>
						  </div>
						  <form:input path="title" type="text" class="form-control form-control-sm" placeholder="(optional)" required="required" />
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Datum: </span>
						  </div>
						  <form:input path="date" type="date" class="form-control form-control-sm" />
					</div>
					
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Dozent: </span>
						  </div>
						  <form:input path="lecturer" type="text" class="form-control form-control-sm" placeholder="(optional)" />
					</div>

					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Anzahl (1-100): </span>
						  </div>
						  <form:input path="number" type="number" class="form-control form-control-sm" min="1" max="100" placeholder="(1-100)" required="required" />
					</div>
					
					<input type="submit" class="btn btn-outline-success" value="SUCHEN">
					
				</form:form>
	
			</div>
			
			
			<div class="col-lg-12 text-center">
				
				<c:if test="${not empty listEvents}">
				
					<table class="table table-bordered table-bottom table-top">
						<thead>
							<tr>
							  <th scope="col">Date</th>
							  <th scope="col">Titel</th>
							  <th scope="col">Von</th>
							  <th scope="col">Bis</th>
							  <th scope="col">Raum</th>
							  <th scope="col">Dozent</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="event" items="${listEvents}">
									<tr>
									  <td><fmt:formatDate value="${event.date}" type="date" pattern="dd.MM.yyyy"/></td>
									  <td>${event.name}</td>
									  <td><fmt:formatDate value="${event.begin}" type="date" pattern="HH:mm"/></td>
									  <td><fmt:formatDate value="${event.end}" type="date" pattern="HH:mm"/></td>
									  <td>${event.room}</td>
									  <td>${event.lecturer}</td>
									</tr>
					    	</c:forEach>
						</tbody> 
					</table>
				  	
			
			
			
				</c:if>
			
			
	  		</div>
			
			
			
			

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