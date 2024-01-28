package model.Beans.AbstractFactory;

public class FactoryBiol implements IAbstractFactory  {

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentBiol();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherBiol();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorBiol();
	}

}
