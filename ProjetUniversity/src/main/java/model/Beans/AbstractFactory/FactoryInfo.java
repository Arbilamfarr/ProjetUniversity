package model.Beans.AbstractFactory;

public class FactoryInfo implements IAbstractFactory {

	@Override
	public Student createStudent() {
		// TODO Auto-generated method stub
		return new StudentInfo();
	}

	@Override
	public Teacher createTeacher() {
		// TODO Auto-generated method stub
		return new TeacherInfo();
	}

	@Override
	public Administrator createAdministrator() {
		// TODO Auto-generated method stub
		return new AdministratorInfo();
	}


}
