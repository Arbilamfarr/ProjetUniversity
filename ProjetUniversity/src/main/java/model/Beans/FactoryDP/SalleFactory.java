package model.Beans.FactoryDP;

public class SalleFactory implements IFactory{

	@Override
	public Building createBuilding() {
		// TODO Auto-generated method stub
		return new Salle();
	}

}
