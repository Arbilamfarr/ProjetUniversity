package model.DAO.Teacher_DAO;

import java.util.ArrayList;



import model.Beans.AbstractFactory.Teacher;
import model.DAO.SingletonDP.JDBC_Connexion;

import java.sql.*;

public class Teacher_Dao_Jdbc implements ITeacher_Dao {
	private Connection conn;
	JDBC_Connexion jdbc_connection = JDBC_Connexion.getInstance();

	public Teacher_Dao_Jdbc() throws SQLException {

		this.conn = jdbc_connection.getConnection();
	}

	@Override
	public ArrayList<Teacher> findAll() {
		Statement st = null;
		ResultSet rs = null;

		ArrayList<Teacher> listtch = new ArrayList<Teacher>();
		String sql = "SELECT * FROM Teacher";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Teacher tch = new Teacher();
				tch.setLastname(rs.getString("lastname"));
				tch.setFirstname(rs.getString("firstname"));
				tch.setFunction(rs.getString("function"));
				tch.setCin(rs.getString("cin"));
				tch.setId_teacher(rs.getString("Id_teacher"));
				listtch.add(tch);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listtch;
	}

	@Override
	public Teacher findtchByid_teacher(String Id_teacher) {
		Statement st = null;
		ResultSet rs = null;
		int i = 0;
		Teacher tch = new Teacher();
		String sql = "SELECT * FROM Teacher where Id_teacher='" + Id_teacher + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				tch.setLastname(rs.getString("lastname"));
				tch.setFirstname(rs.getString("firstname"));
				tch.setFunction(rs.getString("function"));
				tch.setCin(rs.getString("cin"));
				tch.setId_teacher(rs.getString("Id_teacher"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tch;
	}

	@Override
	public void inserttch(Teacher tch) {
		Statement st = null;
		int i = 0;
		String sql = "insert into Teacher(lastname, firstname, function,cin,Id_teacher)" + "values('"
				+ tch.getLastname() + "','" + tch.getFirstname() + "','" + tch.getFunction() + "','" + tch.getCin()
				+ "','" + tch.getId_teacher() + "')";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int updatetch(Teacher tch, String Id_teacher) {
		Statement st = null;
		int i = 0;
		String sql = "update Teacher set lastname ='" + tch.getLastname() + "',firstname='" + tch.getFirstname()
				+ "',function='" + tch.getFunction() + "',cin='" + tch.getCin() + "',Id_teacher='" + tch.getId_teacher()
				+ "'where Id_teacher='" + Id_teacher + "'";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public void deletetch(String Id_teacher) {
		Statement st = null;
		int i = 0;
		String sql = "delete from Teacher where Id_teacher='" + Id_teacher + "'";

		try {
			st = conn.createStatement();
			i = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
