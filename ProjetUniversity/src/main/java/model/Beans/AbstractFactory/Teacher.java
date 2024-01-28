package model.Beans.AbstractFactory;

public class Teacher extends Person {
    private String  id_teacher;
	public Teacher() {
		super();
		
	}
	public String getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(String id_teacher) {
		this.id_teacher = id_teacher;
	}

}
