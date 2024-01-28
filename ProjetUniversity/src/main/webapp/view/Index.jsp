<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="Layout/Header.jsp" />


	<div class="container-fluid mt-4">
		<div class="row">
			<!-- Aside -->
			<aside class="col-md-2">
				<div class="list-group">

					<a href="#"
						class="list-group-item list-group-item-action my-2 rounded-2"
						onclick="loadContent('EtudiantInformation.jsp')">Etudiant</a>
						 <a
						href="#"
						class="list-group-item list-group-item-action my-2 rounded-2"
						onclick="loadContent('TeacherInformation.jsp')">Professeur</a>
					<a href="#"
						class="list-group-item list-group-item-action my-2 rounded-2"
						onclick="loadContent('Building.jsp')">Département</a>

				</div>
			</aside>


			<main
				class="col-md-10 d-flex justify-content-center bg-light rounded-3"
				id="main-content">

				<h2 class="d-flex justify-content-center align-items-center">Bienvenue
					à la Faculté des Sciences Chouaib Doukkali</h2>

			</main>
		</div>
	</div>


	<script>
		function loadContent(page) {
			$.ajax({
				url : page,
				type : 'GET',
				success : function(data) {
					$('#main-content').html(data);
				},
				error : function() {
					alert('Erreur lors du chargement de la page.');
				}
			});
		}
	</script>

</body>
</html>
