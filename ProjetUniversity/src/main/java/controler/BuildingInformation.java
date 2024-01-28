package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Beans.FactoryDP.Building;
import model.DAO.Building_DAO.Building_Dao_jdbc;

/**
 * Servlet implementation class BuildingInformation
 */
@WebServlet("/BuildingInformation")
public class BuildingInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location=request.getParameter("location");
		int size=Integer.parseInt(request.getParameter("size"));
		String function=request.getParameter("function");
		String description=request.getParameter("description");
		Building bld=new Building();
		bld.setLocation(location);
		bld.setSize(size);
		bld.setFunction(function);
		bld.setDescription(description);
		
		Building_Dao_jdbc bld_dao_jdbc=null;
		try {
			bld_dao_jdbc=new Building_Dao_jdbc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bld_dao_jdbc.insertBuilding(bld);
		
		
	}

}
