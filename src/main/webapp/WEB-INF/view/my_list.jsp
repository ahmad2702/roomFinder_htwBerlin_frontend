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
          
          <li class="nav-item">
            <a class="nav-link" href="/search">Search</a>
          </li>
          <li class="nav-item active">
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
					<div class="col-lg-12 text-center">
						
						<h3 class="mt-5">
							Liste
						</h3>
						
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
	
										<tr>
										  <td>15.05.2019</td>
										  <td>WH C 613</td>
										  <td>11:00</td>
										  <td>12:00</td>
										  <td><button type="button" class="btn btn-secondary btn-sm">remove</button></td>
										</tr>
	
							</tbody> 
						</table>
					</div>	
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