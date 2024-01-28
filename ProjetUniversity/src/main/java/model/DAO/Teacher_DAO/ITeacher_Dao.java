package model.DAO.Teacher_DAO;

import java.util.ArrayList;

import model.Beans.AbstractFactory.Teacher;

public interface ITeacher_Dao {
	ArrayList<Teacher> findAll();

	
	void inserttch(Teacher tch);

	int updatetch(Teacher tch, String id_teacher);

	void deletetch(String id_teacher);

	Teacher findtchByid_teacher(String id_teacher);
}
