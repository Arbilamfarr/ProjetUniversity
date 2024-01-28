package model.DAO.Student_DAO;

import java.util.ArrayList;

import model.Beans.AbstractFactory.Student;

public interface IStudent_Dao {
	ArrayList<Student> findAll();

	Student findStdByCne(String cne);

	void insertStd(Student std);

	int updateStd(Student std, String cne);

	void deleteStd(String cne);
}
