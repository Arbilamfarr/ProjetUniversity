<%@page import="model.Beans.AbstractFactory.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un Professeur</title>
<!-- Ajouter les liens vers les fichiers Bootstrap -->
<link rel="stylesheet" href="view/bootstrap/css/bootstrap.min.css">
<script src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%
	Teacher tch = new Teacher();
	tch = (Teacher) request.getAttribute("Tch");
	%>
	<div class="container mt-5 col-md-10 bg-light rounded-2">
		<h2 class="text-center">Modifier un Profeseur</h2>
		<form action="/ProjetUniversity/TeacherInformation" method="post">
			<div class="form-group m-2">
				<label for="lastname ">Nom:</label> <input type="text"
					class="form-control" id="lastname" name="lastname"
					value="<%=tch.getLastname()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="firstname">Prénom:</label> <input type="text"
					class="form-control" id="firstname" name="firstname"
					value="<%=tch.getFirstname()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="function">Fonction:</label> <input type="text"
					class="form-control" id="function" name="function"
					value="<%=tch.getFunction()%>" required>
			</div>
			<div class="form-group m-2">
				<label for="cin">CIN:</label> <input type="text"
					class="form-control" id="cin" name="cin" value="<%=tch.getCin()%>"
					required>
			</div>
			<div class="form-group m-2">
				<label for="cne">ID Professeur:</label> <input type="text"
					class="form-control" id="id_teacher" name="id_teacher"
					value="<%=tch.getId_teacher()%>" readonly required>
			</div>
			<button type="submit" class="btn btn-outline-info m-2">Modifier</button>
			<button type="reset" class="btn btn-outline-danger m-2">Reset</button>
		</form>
	</div>

</body>
</html>
