package model.Beans.AbstractFactory;

public class FactoryMath implements IAbstractFactory {

	

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentMath();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherMath();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorMath();
	}

}
