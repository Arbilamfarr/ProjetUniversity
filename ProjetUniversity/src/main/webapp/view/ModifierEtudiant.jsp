<%@page import="model.Beans.AbstractFactory.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un étudiant</title>
<!-- Ajouter les liens vers les fichiers Bootstrap -->
<link rel="stylesheet" href="view/bootstrap/css/bootstrap.min.css">
<script src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%
	Student std = new Student();
	std = (Student) request.getAttribute("std");
	%>
	<div class="container mt-5 col-md-10 bg-light rounded-2">
		<h2 class="text-center">Modifier un étudiant</h2>
		<form action="/ProjetUniversity/EtudiantInformation" method="post">
			<div class="form-group m-2">
				<label for="lastname ">Nom:</label> <input type="text"
					class="form-control" id="lastname" name="lastname"
					value="<%=std.getLastname()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="firstname">Prénom:</label> <input type="text"
					class="form-control" id="firstname" name="firstname"
					value="<%=std.getFirstname()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="function">Filiére:</label> <input type="text"
					class="form-control" id="function" name="function"
					value="<%=std.getFunction()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="cin">CIN:</label> <input type="text"
					class="form-control" id="cin" name="cin" value="<%=std.getCin()%>"
					required>
			</div>
			<div class="form-group m-2">
				<label for="cne">CNE:</label> <input type="text"
					class="form-control" id="cne" name="cne"
					value="<%=std.getCne()%>" readonly required>
			</div>
			<button type="submit" class="btn btn-outline-info m-2">Modifier</button>
			<button type="reset" class="btn btn-outline-danger m-2">Reset</button>
		</form>
	</div>

</body>
</html>
