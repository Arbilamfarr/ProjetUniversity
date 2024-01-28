package model.Beans.AbstractFactory;

public class Person {
  private String lastname;
  private String firstname;
  private String function;
  private String cin;
  
  
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getFunction() {
	return function;
}
public void setFunction(String function) {
	this.function = function;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
}
