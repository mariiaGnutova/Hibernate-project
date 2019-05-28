package com.java.test.project.dao.autosDAO;

import com.java.test.project.models.Auto;

import java.util.List;

public interface AutoDAO {
	Auto findById(int id);
	void save(Auto auto);
	void update(Auto auto);
	void delete(Auto auto);
	List<Auto> findAll();
}
