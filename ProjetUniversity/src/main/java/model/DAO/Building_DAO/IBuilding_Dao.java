package model.DAO.Building_DAO;

import java.util.ArrayList;
import java.util.List;

import model.Beans.FactoryDP.Building;

public interface IBuilding_Dao {
      boolean insertBuilding(Building bld );
      List<Building> buildingFindAll();
	
      
      
}
