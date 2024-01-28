<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un étudiant</title>
<!-- Ajouter les liens vers les fichiers Bootstrap -->
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script src="./bootstrap/sweetalert/alert.js"></script>

</head>
<body>

	<div class="container mt-5 col-md-10 bg-light rounded-2">
		<h2 class="text-center">Ajouter un étudiant</h2>
		<form action="/ProjetUniversity/EtudiantInformation" method="post" onsubmit="return Ajouter()">
			<div class="form-group m-2">
				<label for="lastname ">Nom:</label> <input type="text"
					class="form-control" id="lastname" name="lastname" required>
			</div>
			<div class="form-group m-2">
				<label for="firstname">Prénom:</label> <input type="text"
					class="form-control" id="firstname" name="firstname" required>
			</div>
			<div class="form-group m-2">
				<label for="function">Filiére:</label> <input type="text"
					class="form-control" id="function" name="function" required>
			</div>
			<div class="form-group m-2">
				<label for="cin">CIN:</label> <input type="text"
					class="form-control" id="cin" name="cin" required>
			</div>
			<div class="form-group m-2">
				<label for="cne">CNE:</label> <input type="text"
					class="form-control" id="cne" name="cne" required>
			</div>
			<button type="submit"  class="btn btn-outline-info m-2">Ajouter</button>
			<button type="reset" class="btn btn-outline-danger m-2">Reset</button>
		</form>
	</div>
	<script>
		function Ajouter() {
			 Swal.fire({
		            title: "Etudiant été Ajouter!",
		            text: "You clicked the button!",
		            icon: "success",
		            timer: 1000, // Temps en millisecondes (ici, 5 secondes)
		            showConfirmButton: false // Masquer le bouton "OK"
		        });
		}
	</script>

</body>
</html>
