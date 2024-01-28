package model.Beans.AbstractFactory;

public class FactoryChim  implements IAbstractFactory {

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentChim();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherChim();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorChim();
	}

}
