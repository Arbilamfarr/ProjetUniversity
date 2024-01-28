package model.Beans.FactoryDP;

public class AdministrationFactory implements IFactory {

	@Override
	public Building createBuilding() {
		// TODO Auto-generated method stub
		return new Administration();
	}

}
