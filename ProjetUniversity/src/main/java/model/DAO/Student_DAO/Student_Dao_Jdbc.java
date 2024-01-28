package model.DAO.Student_DAO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Beans.AbstractFactory.Student;
import model.DAO.SingletonDP.JDBC_Connexion;

import java.sql.*;

public class Student_Dao_Jdbc implements IStudent_Dao {
	private Connection conn;
	JDBC_Connexion jdbc_connection = JDBC_Connexion.getInstance();

	public Student_Dao_Jdbc() throws SQLException {

		this.conn = jdbc_connection.getConnection();
	}

	@Override
	public ArrayList<Student> findAll() {
		Statement st = null;
		ResultSet rs = null;
	
		ArrayList<Student> listetd = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Student std = new Student();
				std.setLastname(rs.getString("lastname"));
				std.setFirstname(rs.getString("firstname"));
				std.setFunction(rs.getString("function"));
				std.setCin(rs.getString("cin"));
				std.setCne(rs.getString("cne"));
				listetd.add(std);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Recherche terminée...!");
//	    } else { JOptionPane.showMessageDialog(null, "Table vide...!"); }

		return listetd;
	}

	@Override
	public Student findStdByCne(String cne) {
		Statement st = null;
		ResultSet rs = null;
		int i = 0;
		Student std = new Student();
		String sql = "SELECT * FROM student where cne='" + cne + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				std.setLastname(rs.getString("lastname"));
				std.setFirstname(rs.getString("firstname"));
				std.setFunction(rs.getString("function"));
				std.setCin(rs.getString("cin"));
				std.setCne(rs.getString("cne"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Recherche terminée...!");
//	    } else { JOptionPane.showMessageDialog(null, "CNE non valide...!"); }
//		
		return std;
	}

	@Override
	public void insertStd(Student std) {
		Statement st = null;
		int i = 0;
		String sql = "insert into student(lastname, firstname, function,cin,cne)" + "values('" + std.getLastname()
				+ "','" + std.getFirstname() + "','" + std.getFunction() + "','" + std.getCin() + "','" + std.getCne()
				+ "')";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Etudiant inseré...!");
//		    } else { JOptionPane.showMessageDialog(null, "Etudiant non inseré...!"); }

	}

	@Override
	public int updateStd(Student std, String cne) {
		Statement st = null;
		int i = 0;
		String sql = "update student set lastname ='" + std.getLastname() + "',firstname='" + std.getFirstname()
				+ "',function='" + std.getFunction() + "',cin='" + std.getCin() + "',cne='" + std.getCne()
				+ "'where cne='" + cne + "'";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Etudiant modifié...!");
//	    } else { JOptionPane.showMessageDialog(null, "Etudiant non modifié...!"); }
		return i;
	}

	@Override
	public void deleteStd(String cne) {
		Statement st = null;
		int i = 0;
		String sql = "delete from student where cne='" + cne + "'";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Etudiant suprimé...!");
//	    } else { JOptionPane.showMessageDialog(null, "Etudiant non suprimé...!"); }

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
