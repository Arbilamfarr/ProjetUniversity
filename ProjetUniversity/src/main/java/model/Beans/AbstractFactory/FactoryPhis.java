package model.Beans.AbstractFactory;

public class FactoryPhis implements IAbstractFactory  {

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentPhis();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherPhis();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorPhis();
	}

	

}
