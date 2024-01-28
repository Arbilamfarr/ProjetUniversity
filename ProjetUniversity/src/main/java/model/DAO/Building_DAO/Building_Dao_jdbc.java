package model.DAO.Building_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;

import model.Beans.FactoryDP.Building;
import model.DAO.SingletonDP.JDBC_Connexion;

public class Building_Dao_jdbc implements IBuilding_Dao {

	private Connection conn;
	JDBC_Connexion jdbc_connection = JDBC_Connexion.getInstance();

	public Building_Dao_jdbc() throws SQLException {

		this.conn = jdbc_connection.getConnection();
	}

	@Override
	public List<model.Beans.FactoryDP.Building> buildingFindAll() {
		Statement st = null;
		ResultSet rs = null;
	
		ArrayList<Building> listbld = new ArrayList<Building>();
		String sql = "SELECT * FROM building";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
			Building bld = new Building();
				bld.setLocation(rs.getString("location"));
				bld.setSize(rs.getInt("size"));
				bld.setFunction(rs.getString("function"));
				bld.setDescription(rs.getString("description"));
				
				listbld.add(bld);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if (i > 0) { JOptionPane.showMessageDialog(null, "Recherche terminée...!");
//	    } else { JOptionPane.showMessageDialog(null, "Table vide...!"); }

		return listbld;
	}

	@Override
	 public boolean insertBuilding(Building building) {
	       
	        PreparedStatement preparedStatement = null;
	        boolean success = false;

	        try {
	            String sql = "INSERT INTO building (location, size, function, description) VALUES (?, ?, ?, ?)";

	            // Préparer la déclaration SQL
	            preparedStatement = conn.prepareStatement(sql);
	            preparedStatement.setString(1, building.getLocation());
	            preparedStatement.setInt(2, building.getSize());
	            preparedStatement.setString(3, building.getFunction());
	            preparedStatement.setString(4, building.getDescription());

	            // Exécuter la déclaration SQL
	            int rowsAffected = preparedStatement.executeUpdate();
	            success = rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return success;
	    }

	

}
