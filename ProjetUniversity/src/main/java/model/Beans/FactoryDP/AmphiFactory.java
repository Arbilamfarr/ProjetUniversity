package model.Beans.FactoryDP;

public class AmphiFactory implements IFactory {

	@Override
	public Building createBuilding() {
		
		return new Amphi();
	}

	

}
