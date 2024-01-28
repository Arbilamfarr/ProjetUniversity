package model.Beans.AbstractFactory;

public class Administrator  extends Person{
    private String id_administrator;
	public Administrator() {
		super();
	}
	public String getId_administrator() {
		return id_administrator;
	}
	public void setId_administrator(String id_administrator) {
		this.id_administrator = id_administrator;
	}

}
