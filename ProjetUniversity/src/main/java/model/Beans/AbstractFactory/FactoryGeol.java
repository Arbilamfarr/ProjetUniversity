package model.Beans.AbstractFactory;

public class FactoryGeol implements IAbstractFactory  {

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentGeol();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherGeol();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorGeol();
	}

}
