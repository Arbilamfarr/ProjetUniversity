<%@page import="java.util.ArrayList"%>
<%@page import="model.Beans.AbstractFactory.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Professeur Information</title>
<!-- Ajouter la référence à Bootstrap ici -->
<link rel="stylesheet" href="view/bootstrap/css/bootstrap.min.css">

<script src="view/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid ">
		<div class="container-fluid  w-100 mt-5">
			<h2 class="text-center mb-4 text-primary">Les informations des
				professeurs</h2>

			<div class="row">
				<div class="col-lg-12 aligns-items-center ">

					<!-- Boutons à gauche -->
					<form action="/ProjetUniversity/TeacherInformation" method="GET"
						class="d-flex">
						<div class="col-md-6">
							<input type="submit" name="action" value="afficher"
								class="btn btn-warning m-2" id="afficher"> <input
								type="submit" name="action" value="ajouter"
								class="btn btn-success m-2" id="afficher">

						</div>
						<div class="col-md-6">
							<!-- Champ de recherche et bouton de recherche à droite -->
							<div class="input-group m-2">
								<input type="text" class="form-control rounded-1" name="id_teacher"
									placeholder="Saisir id professuer...">
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

		<%
		// Récupérer la liste des étudiants à partir de la requête
		ArrayList<Teacher> listeTeachers = (ArrayList<Teacher>) request.getAttribute("listeTeachers");

		// Afficher la liste des étudiants dans un tableau
		if (listeTeachers != null && !listeTeachers.isEmpty()) {
		%>

		<table class="table table-bordered mt-4  table-hover">
			<thead class="table-dark">
				<tr>
					<th>Identifiant de professeur</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Fonction</th>
					<th>CIN</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Teacher Professeur : listeTeachers) {
				%>
				<tr>
					<td><%=Professeur.getId_teacher()%></td>
					<td><%=Professeur.getLastname()%></td>
					<td><%=Professeur.getFirstname()%></td>
					<td><%=Professeur.getFunction()%></td>
					<td><%=Professeur.getCin()%></td>
					<td>
						<form action="/ProjetUniversity/TeacherInformation" method="GET">
							<input type="hidden" name="id_teacher" value="<%=Professeur.getId_teacher() %>">
							<input type="submit" name="action" value="supprimer"
								class="btn btn-danger">
							<!-- Supprimer l'étudiant -->
							<input type="submit" name="action" value="modifier"
								class="btn btn-warning">
							<!-- Modifier l'étudiant -->
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		} else {
		// Aucun étudiant trouvé dans la liste
		out.println("<p class='mt-4 text-danger fs-1 d-flex justify-content-center '>Aucun professeur trouvé.</p>");
		}
		%>

	</div>
</body>
</html>
