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
          
          <li class="nav-item active">
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
          
        </ul>
      </div>
    </div>
  </nav>
	
	
	
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			
			<div class="col-lg-12 text-center">
				

		            <a href="<c:url value="/search/event" />" class="btn btn-outline-success" role="button" aria-pressed="true" style="
		            margin:100px auto;
					display: flex;
					flex-direction: column;
					justify-content: center;
					height: 100px;
					overflow: auto;">
		            	- ICH SUCHE EIN BESTIMMTES RAUM EINER VERANSTALTUNG -
		            </a>


		            <a href="<c:url value="/search/freeRoom" />" class="btn btn-outline-danger" role="button" aria-pressed="true" style="
		            margin:100px auto;
					display: flex;
					flex-direction: column;
					justify-content: center;
					height: 100px;
					overflow: auto;">
		            	- ICH SUCHE EINEN FREIEN RAUM -
		            </a>



			</div>

		</div>
	</div>
	
	
	
	
	

	
	  <!-- Bootstrap core JavaScript -->
	  <script src="<c:url value="/" />resources/jquery/jquery.slim.min.js"></script>
	  <script src="<c:url value="/" />resources/bootstrap/js/bootstrap.bundle.min.js"></script>

	
</body>
</html>