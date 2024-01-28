package model.Beans.AbstractFactory;

public interface IAbstractFactory {

	public Student createStudent();
	public Teacher createTeacher();
	public Administrator createAdministrator();
	
}
