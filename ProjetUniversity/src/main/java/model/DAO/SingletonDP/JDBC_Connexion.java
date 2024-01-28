package model.DAO.SingletonDP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connexion {

    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String LOCAL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWD = "";
    
    
//    String driver = "com.mysql.cj.jdbc.Driver";
//	String con = "jdbc:mysql://localhost:3306/university";
    // Instance unique
    private static JDBC_Connexion Singleton;
    private static Connection jdbc_con;

    // Constructeur privé pour empêcher l'instanciation directe
    private JDBC_Connexion() {
    	
    	 }
  
    
    public static JDBC_Connexion getInstance() {
        if (Singleton == null) {
        	Singleton = new JDBC_Connexion();
        }
        return Singleton;
    }

    public Connection getConnection() {
    	 try {
 			if (jdbc_con == null || ((Connection) jdbc_con).isClosed()) {
 				 try {
 			         Class.forName(DRIVER);
 			         jdbc_con =DriverManager.getConnection(LOCAL, USER, PASSWD);
 			     } catch (ClassNotFoundException e) {
 			         throw new SQLException("Le pilote JDBC n'a pas pu être chargé.", e);
 			     }}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        return jdbc_con;
    }
}
