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
	<div class="container-fluid ">
		<div class="container-fluid  w-100 mt-5">
			<h2 class="text-center mb-4 text-primary">Les informations des
				étudiants</h2>

			<div class="row">
				<div class="col-lg-12 aligns-items-center ">

					<!-- Boutons à gauche -->
					<form action="/ProjetUniversity/EtudiantInformation" method="GET"
						class="d-flex">
						<div class="col-md-6">
							<input type="submit" name="action" value="afficher"
								class="btn btn-warning m-2" id="afficher" > <input
								type="submit" name="action" value="ajouter"
								class="btn btn-success m-2" id="afficher" >

						</div>
						<div class="col-md-6">
							<!-- Champ de recherche et bouton de recherche à droite -->
							<div class="input-group m-2">
								<input type="text" class="form-control rounded-1" name="cne"
									placeholder="Saisir cne...">
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
		ArrayList<Student> listeEtudiants = (ArrayList<Student>) request.getAttribute("listeEtudiants");

		// Afficher la liste des étudiants dans un tableau
		if (listeEtudiants != null && !listeEtudiants.isEmpty()) {
		%>

		<table class="table table-bordered mt-4  table-hover">
			<thead class="table-dark">
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
				<%
				for (Student etudiant : listeEtudiants) {
				%>
				<tr>
					<td><%=etudiant.getCne()%></td>
					<td><%=etudiant.getLastname()%></td>
					<td><%=etudiant.getFirstname()%></td>
					<td><%=etudiant.getFunction()%></td>
					<td><%=etudiant.getCin()%></td>
					<td>
						<form action="/ProjetUniversity/EtudiantInformation" method="GET">
							<input type="hidden" name="cne" value="<%=etudiant.getCne()%>">
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
		out.println("<p class='mt-4 text-danger fs-1 d-flex justify-content-center '>Aucun étudiant trouvé.</p>");
		}
		%>

	</div>
</body>
</html>
