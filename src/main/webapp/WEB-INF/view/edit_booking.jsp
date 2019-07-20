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
          
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/search" />">Search</a>
          </li>
          <li class="nav-item active">
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
					<div class="col-lg-12 text-left">
						
						<h3 class="mt-5">
							Edit Booking
						</h3>
						<br><br><br>
						
						
						<p>
								Room: ${booking.room}
								<br><br>
	                            
	                            Datum: <fmt:formatDate value="${booking.date}" type="date" pattern="dd.MM.yyyy"/>
								<br><br>
								
								Begin: <fmt:formatDate value="${booking.begin}" type="date" pattern="HH:mm"/>
								<br><br>
								
								End: <fmt:formatDate value="${booking.end}" type="date" pattern="HH:mm"/>
								<br><br><br><br>
								
								Users: 
								<br>
								
								<form:form action="edit/addUser" method="POST" modelAttribute="addUser">
										<form:input path="bookingId" type="hidden" value="${booking.id}" />
										
										<form:input path="username" type="text" required="required"/>
										<input type="submit" value="hinzufügen">
								</form:form>
								<br><br>
							
								
									<form:form action="edit/removeUser" method="POST" modelAttribute="removeUser">
										<c:forEach var="user" items="${booking.users}">
											
											<c:if test="${user.id}=='2'">
												yeeees
											</c:if>
											
											<form:input path="bookingId" type="hidden" value="${booking.id}" />
											<form:input path="userId" type="hidden" value="${user.id}" />
											
											${user.firstname} ${user.lastname} (${user.username}) 
											
											<input type="submit" value="remove">
											<br>
										
										</c:forEach>
									</form:form>
									<br>
								
								
								<br><br><br>
								

						</p>
						
						
					</div>	
		  	</div>	
			
			
			
			
			
			
			
			
			
			
			
	    </div>
	</div>
	
	






  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/" />resources/jquery/jquery.slim.min.js"></script>
  <script src="<c:url value="/" />resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>