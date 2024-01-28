<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saisie d'un Building</title>
    
    <!-- Inclure les fichiers Bootstrap -->
<link rel="stylesheet" href="view/bootstrap/css/bootstrap.min.css">

<script src="view/bootstrap/js/bootstrap.min.js"></script></head>
<body>

<div class="container mt-4">
    <form action="/ProjetUniversity/BuildingInformation" method="post">
        <div class="form-group">
            <label for="location">Emplacement:</label>
            <input type="text" class="form-control" id="location" name="location" required>
        </div>

        <div class="form-group">
            <label for="size">Taille:</label>
            <input type="number" class="form-control" id="size" name="size" required>
        </div>

        <div class="form-group">
            <label for="function">Fonction:</label>
            <select class="form-control" id="function" name="function" required>
                <option value="salle">Salle</option>
                <option value="amphi">Amphithéâtre</option>
                <option value="bibliotheque">Bibliothèque</option>
                <option value="administration">Administration</option>
            </select>
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
        </div>

        <button type="submit" class="btn btn-primary">Enregistrer</button>
    </form>
</div>



</body>
</html>
