<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HTW Berlin | Room Finder</title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value="/" />resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Custom core CSS -->
  <link href="<c:url value="/" />resources/css/navbar_custom.css" rel="stylesheet">
  <link href="<c:url value="/" />resources/css/position_custom.css" rel="stylesheet">

  <!-- Favicon -->
  <link rel="shortcut icon" href="<c:url value="/" />resources/images/favicon.ico" type="image/x-icon">

</head>

<body>
	
	<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark navbar-custom static-top">
    <div class="container">
      <a class="navbar-brand" href="<c:url value="/" />">HTW Berlin | Room Finder</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          
          	<security:authorize access="isAuthenticated()">
		    	
		    	<li class="nav-item">
		            <a class="nav-link" href="<c:url value="/search" />">Search</a>
		        </li>
		        <li class="nav-item">
		            <a class="nav-link" href="<c:url value="/myList" />">Buchungen</a>
		        </li>
		        <li class="nav-item">
		            <a class="nav-link" href="<c:url value="/account" />">Mein Profil</a>
		        </li>
		        <li class="nav-item">
		            <a class="nav-link" href="<c:url value="/logout" />">LOGOUT</a>
		        </li>
		    	
			</security:authorize>
			
			<security:authorize access="!isAuthenticated()">
          		<li class="nav-item">
		            <a class="nav-link" href="<c:url value="/login" />">Login</a>
		        </li>
          	</security:authorize>
          
        </ul>
      </div>
    </div>
  </nav>
	
	
	
	
	<!-- Page Content -->
  <div class="container">
    <div class="row">
      	<div class="col-lg-12 text-left">
	  
	        <h1 class="mt-5">Willkommen!</h1>
	        <br>
	        <p class="lead"><b>Dieses Portal stellt Dir die folgenden Funktionen zur Verf�gung: </b></p>
	        1.  Suchst du den Raum einer bestimmten Veranstaltung? Kein Problem! 
	            Du kannst schnell den Raum dieser Veranstaltung finden! <br>
	            
	        2.  Brauchst du einen freien Raum f�r eine Gruppenarbeit? Kein Problem!
	            Du kannst schnell einen Raum finden, belegen und deine Kommilitonen zu deiner Buchung hinzuf�gen!
			
			<br> <br> <br> 
			
			<p class="lead"><b>Um diese Suchfunktion benutzen zu k�nnen, muss Du angemeldet sein!</b></p>
			
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
  <script src="<c:url value="/" />resources/jquery/jquery.slim.min.js"></script>
  <script src="<c:url value="/" />resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>