package model.Beans.AbstractFactory;

public class Student extends Person {
   private String cne;

	public Student() {
		super();
	}

	
	public String getCne() {
	return cne;
}
public void setCne(String cne) {
	this.cne = cne;
}
}
