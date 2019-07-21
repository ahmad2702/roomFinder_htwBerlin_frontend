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
            <a class="nav-link" href="<c:url value="/myList" />">Meine Liste</a>
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
			
			<div class="col-lg-12 text-left">
			
				<h1 class="mt-5">SUCHMASCHINE: Module</h1>
		        <p class="lead">Bitte fülle die folgenden Felder aus:</p>

			</div>
			
			
			
			
			<!-- Search Form for Events START-->
			<div class="col-lg-12 text-left" id="searchEventForm">

				<form:form action="" method="POST" modelAttribute="eventSearchForm">
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Titel* : </span>
						  </div>
						  <form:input path="title" type="text" class="form-control form-control-sm" placeholder="z.B. Mathe oder Mathematik" required="required" />
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
							<span class="input-group-text" id="inputGroup-sizing-sm">Ergebnisanzahl* : </span>
						  </div>
						  <form:input path="number" type="number" class="form-control form-control-sm" min="1" max="100" placeholder="von 1 bis 100" required="required" value="15" />
					</div>
					
					<span class="small">
						*Pflichtfelder
					</span> 
					<br>
					
					<input type="submit" class="btn btn-outline-success" value="SUCHEN" onClick="$('button').prop('disabled', true);" />
					
				</form:form>

				
				<div class="col-lg-12 text-center">
					
					<c:if test="${not empty listEvents}">
				
						<table class="table table-bordered table-bottom table-top table-responsive-sm">
							<thead>
								<tr>
								  <th scope="col">Datum</th>
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
										  <td><a target="_blank" rel="noopener noreferrer" href="https://lsf.htw-berlin.de/qisserver/rds?state=wsearchv&search=2&veranstaltung.veranstid=${event.lsf_id}">${event.name}</a></td>
										  <td><fmt:formatDate value="${event.begin}" type="date" pattern="HH:mm"/></td>
										  <td><fmt:formatDate value="${event.end}" type="date" pattern="HH:mm"/></td>
										  <td>${event.room}</td>
										  <td>${event.lecturer}</td>
										</tr>
									</c:forEach>
							</tbody> 
						</table>
						
					</c:if>
					
					<c:if test="${startSearch==false}">
						
						<c:if test="${empty listEvents}">
							Nichts gefunden! 
						</c:if>
						
					</c:if>
					
				</div>
				
	  		</div>
			<!-- Search Form for Events END-->

			
			

		</div>
	</div>
	
	
	
	

	
	  <!-- Bootstrap core JavaScript -->
	  <script src="<c:url value="/" />resources/jquery/jquery.slim.min.js"></script>
	  <script src="<c:url value="/" />resources/bootstrap/js/bootstrap.bundle.min.js"></script>

	
</body>
</html>