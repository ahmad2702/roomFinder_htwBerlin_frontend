<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		         
				
				
				<form name="eventFinder" action="" method="POST">
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Title (z.B. Mathematik): </span>
						  </div>
						  <input type="text" class="form-control form-control-sm" placeholder="(optional)" name="eventName">
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Datum: </span>
						  </div>
						  <input type="date" class="form-control form-control-sm" >
					</div>
					
					
					<div class="input-group input-group-sm mb-3">
					  <div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Raumtyp:</label>
					  </div>
					  <select class="custom-select" id="inputGroupSelect01">
						<option selected>Wähle aus...</option>
						<option value="1">frei</option>
						<option value="2">belegt</option>
					  </select>
					</div>
					
					
					<div class="input-group">
						  <div class="input-group-prepend">
							<span class="input-group-text">Zeit: </span>
						  </div>
						  <input type="time" aria-label="First name" class="form-control">
					</div>
					<br>
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Dauer (hh:mm): </span>
						  </div>
						  <input type="time" class="form-control form-control-sm">
					</div>
					
					<div class="input-group input-group-sm mb-3">
						  <div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-sm">Anzahl (1-100): </span>
						  </div>
						  <input type="number" class="form-control form-control-sm" placeholder="(1-100)" name="eventNumber" required>
					</div>
					
					<input type="submit" class="btn btn-outline-success" value="SUCHEN">
					
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
	  <script src="/resources/jquery/jquery.slim.min.js"></script>
	  <script src="/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	
	
</body>
</html>