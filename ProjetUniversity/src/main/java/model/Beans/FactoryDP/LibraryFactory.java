package model.Beans.FactoryDP;

public class LibraryFactory implements IFactory {

	@Override
	public Building createBuilding() {
		// TODO Auto-generated method stub
		return new Library();
	}

}
