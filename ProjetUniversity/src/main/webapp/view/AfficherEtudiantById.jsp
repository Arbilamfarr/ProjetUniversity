<%@page import="java.util.ArrayList"%>
<%@page import="model.Beans.AbstractFactory.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Etudiant Information</title>
<!-- Ajouter la référence à Bootstrap ici -->
<link rel="stylesheet" href="view/bootstrap/css/bootstrap.min.css">

<script src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%
	// Récupérer la liste des étudiants à partir de la requête
	Student std = (Student) request.getAttribute("std");
	if (std.getCne() != null) {
	%>

	<div class="container-fluid ">
		<div class="container-fluid  w-100 mt-5">
			<h2 class="text-center mb-4 text-primary">
				Etudiant :
				<%=std.getLastname() + " " + std.getFirstname()%></h2>

			<div class="row">
				<div class="col-lg-12">
					<!-- Boutons à gauche -->
					<form action="/ProjetUniversity/EtudiantInformation" method="GET"
						class="d-flex  ">
						<div class="col-md-6 justify-content-start">
							<input type="submit" name="action" value="afficher"
								class="btn btn-warning m-2">
							<!-- Afficher la liste des étudiants -->
							<input type="submit" name="action" value="ajouter"
								class="btn btn-primary m-2">
							<!-- Ajouter un étudiant -->
						</div>

						<!-- Champ de recherche et bouton de recherche à droite -->
						<div class="col-md-6 justify-content-end">
							<!-- Champ de recherche et bouton de recherche à droite -->
							<div class="input-group m-2">
								<input type="text" class="form-control rounded-1" name="cne"
									placeholder="Saisir cne ...">
								<div class="input-group-append">
									<input type="submit" name="action" value="chercher"
										class="btn btn-info ms-2">
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>





		<table class="table table-bordered">
			<thead>
				<tr>
					<th>CNE</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Filiére</th>
					<th>CIN</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><%=std.getCne()%></td>
					<td><%=std.getLastname()%></td>
					<td><%=std.getFirstname()%></td>
					<td><%=std.getFunction()%></td>
					<td><%=std.getCin()%></td>
					<td>
						<form action="/ProjetUniversity/EtudiantInformation" method="GET">
							<input type="hidden" name="cne" value="<%=std.getCne()%>">
							<input type="submit" name="action" value="supprimer"
								class="btn btn-danger">
							<!-- Supprimer l'étudiant -->
							<input type="submit" name="action" value="modifier"
								class="btn btn-warning">
							<!-- Modifier l'étudiant -->
						</form>
					</td>
				</tr>

			</tbody>
		</table>
		<%
		} else {
		// Aucun étudiant trouvé dans la liste
		out.println("<p class='text-danger fs-2 d-flex justify-content-center mt-5' >Aucun étudiant trouvé.</p>");
		}
		%>
	</div>
</body>
</html>
