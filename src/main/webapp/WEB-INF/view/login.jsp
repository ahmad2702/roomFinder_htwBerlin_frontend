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
  
  <!-- Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
		            <a class="nav-link" href="<c:url value="/login" />">Login</a>
		        </li>

        </ul>
      </div>
    </div>
  </nav>
	
	
	
	
	<!-- Page Content -->
  <div class="container">
    <div class="row">
      	<div class="col-lg-12 text-left">
	  		
	  		<br><br><br>
	  		
	        <c:url value="/j_spring_security_check" var="loginUrl" />

			<h4 class="card-title text-center mb-4 mt-1">USER</h4>
			<hr>
			
			
			<c:if test="${param.error != null}">
			        <p class="text-success text-center">Das von Ihnen eingegebene Login oder Passwort ist falsch! </p>
			</c:if>
						
			
			
			
			<form action="${loginUrl}" method="post">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-prepend">
						    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
						 </div>
						<input type="text" class="form-control" name="j_username" placeholder="Username" required autofocus value="">
					</div> <!-- input-group.// -->
				</div> <!-- form-group// -->
				
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-prepend">
						    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
						 </div>
					    <input type="password" class="form-control" name="j_password" placeholder="Password" required value="">
					</div> <!-- input-group.// -->
				</div> <!-- form-group// -->
				
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block btn-success" type="submit">Anmelden</button>
				</div> <!-- form-group// -->
			
			</form>

		    

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