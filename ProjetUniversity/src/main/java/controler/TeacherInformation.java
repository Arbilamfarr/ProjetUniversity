package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Beans.AbstractFactory.Teacher;
import model.DAO.Teacher_DAO.Teacher_Dao_Jdbc;


@WebServlet("/TeacherInformation")
public class TeacherInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("afficher".equals(action)) {
			try {
				afficherListeTeachers(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("supprimer".equals(action)) {
			try {
				supprimerTeacher(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}
		} else if ("ajouter".equals(action)) {
			response.sendRedirect("view/Teacher.jsp");

		} else if ("modifier".equals(action)) {
			try {
				modifierTeacher(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}

		} else if ("chercher".equals(action)) {

			try {
				chercherTeacher(request, response);
			} catch (ServletException | IOException | SQLException e) {

				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ajouterTeacher(request, response);
	}

	private void afficherListeTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Teacher_Dao_Jdbc Teacher_dao_jdbc = null;
		Teacher_dao_jdbc = new Teacher_Dao_Jdbc();
		ArrayList<Teacher> listeTeachers = Teacher_dao_jdbc.findAll();
		request.setAttribute("listeTeachers", listeTeachers);
		request.getRequestDispatcher("view/TeacherInformation.jsp").forward(request, response);
	}

	private void chercherTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id_teacher = request.getParameter("id_teacher");
		Teacher_Dao_Jdbc Teacher_dao_jdbc = null;
		try {
			Teacher_dao_jdbc = new Teacher_Dao_Jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher Tch = new Teacher();
		Tch = Teacher_dao_jdbc.findtchByid_teacher(id_teacher);
		request.setAttribute("Tch", Tch);
		request.getRequestDispatcher("view/AfficherTeacherById.jsp").forward(request, response);
	}

	private void modifierTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Teacher Tch = new Teacher();
		String id_teacher = request.getParameter("id_teacher");
		Teacher_Dao_Jdbc Teacher_dao_jdbc = null;
		Teacher_dao_jdbc = new Teacher_Dao_Jdbc();
		Tch = Teacher_dao_jdbc.findtchByid_teacher(id_teacher);
		request.setAttribute("Tch", Tch);
		Teacher_dao_jdbc.deletetch(id_teacher);
		request.getRequestDispatcher("view/ModifierTeacher.jsp").forward(request, response);


	}

	private void supprimerTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id_teacher = request.getParameter("id_teacher");
		Teacher_Dao_Jdbc Teacher_dao_jdbc = new Teacher_Dao_Jdbc();
		Teacher_dao_jdbc.deletetch(id_teacher);
		response.sendRedirect("/ProjetUniversity/TeacherInformation?action=afficher");

	}

	private void ajouterTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String function = request.getParameter("function");
		String cin = request.getParameter("cin");
		String id_teacher = request.getParameter("id_teacher");

		Teacher Tch = new Teacher();
		Tch.setLastname(lastname);
		Tch.setFirstname(firstname);
		Tch.setFunction(function);
		Tch.setId_teacher(id_teacher);
		Tch.setCin(cin);

		Teacher_Dao_Jdbc Tch_dao_jdbc = null;
		try {
			Tch_dao_jdbc = new Teacher_Dao_Jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tch_dao_jdbc.inserttch(Tch);
		
		response.sendRedirect("/ProjetUniversity/TeacherInformation?action=afficher");

		
	}

}
