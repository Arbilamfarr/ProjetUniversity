package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Beans.AbstractFactory.Student;
import model.DAO.Student_DAO.Student_Dao_Jdbc;


@WebServlet("/EtudiantInformation")
public class EtudiantInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("afficher".equals(action)) {
			try {
				afficherListeEtudiants(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("supprimer".equals(action)) {
			try {
				supprimerEtudiant(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}
		} else if ("ajouter".equals(action)) {
			response.sendRedirect("view/Student.jsp");

		} else if ("modifier".equals(action)) {
			try {
				modifierEtudiant(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}

		} else if ("chercher".equals(action)) {

			try {
				chercherEtudiant(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ajouterEtudiant(request, response);
	}

	private void afficherListeEtudiants(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Student_Dao_Jdbc student_dao_jdbc = null;
		student_dao_jdbc = new Student_Dao_Jdbc();
		ArrayList<Student> listeEtudiants = student_dao_jdbc.findAll();
		request.setAttribute("listeEtudiants", listeEtudiants);
		request.getRequestDispatcher("view/EtudiantInformation.jsp").forward(request, response);
	}

	private void chercherEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String cne = request.getParameter("cne");
		Student_Dao_Jdbc student_dao_jdbc = null;
		try {
			student_dao_jdbc = new Student_Dao_Jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student std = new Student();
		std = student_dao_jdbc.findStdByCne(cne);
		request.setAttribute("std", std);
		request.getRequestDispatcher("view/AfficherEtudiantById.jsp").forward(request, response);
	}

	private void modifierEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Student std = new Student();
		String cne = request.getParameter("cne");
		Student_Dao_Jdbc student_dao_jdbc = null;
		student_dao_jdbc = new Student_Dao_Jdbc();
		std = student_dao_jdbc.findStdByCne(cne);
		request.setAttribute("std", std);
		student_dao_jdbc.deleteStd(cne);
		request.getRequestDispatcher("view/ModifierEtudiant.jsp").forward(request, response);


	}

	private void supprimerEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String cne = request.getParameter("cne");
		Student_Dao_Jdbc student_dao_jdbc = new Student_Dao_Jdbc();
		student_dao_jdbc.deleteStd(cne);
		response.sendRedirect("/ProjetUniversity/EtudiantInformation?action=afficher");

	}

	private void ajouterEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String function = request.getParameter("function");
		String cin = request.getParameter("cin");
		String cne = request.getParameter("cne");

		Student std = new Student();
		std.setLastname(lastname);
		std.setFirstname(firstname);
		std.setFunction(function);
		std.setCne(cne);
		std.setCin(cin);

		Student_Dao_Jdbc std_dao_jdbc = null;
		try {
			std_dao_jdbc = new Student_Dao_Jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		std_dao_jdbc.insertStd(std);
		
		response.sendRedirect("/ProjetUniversity/EtudiantInformation?action=afficher");

		
	}

}
