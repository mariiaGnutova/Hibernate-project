package com.java.test.project.services.autoService;

import com.java.test.project.dao.autosDAO.AutoDAO;
import com.java.test.project.dao.autosDAO.AutoDAOImpl;
import com.java.test.project.models.Auto;

import java.util.List;

public class AutoServiseImpl implements AutoService{

	private AutoDAO autoDao = new AutoDAOImpl();

	@Override
	public Auto findById(Integer id) {
		return autoDao.findById(id);
	}

	@Override
	public void save(Auto auto) {
		autoDao.save(auto);
	}

	@Override
	public void update(Auto auto) {
		autoDao.update(auto);
	}

	@Override
	public void delete(Auto auto) {
			autoDao.delete(auto);
	}

	@Override
	public List<Auto> findAllAutos() {
		return autoDao.findAll();
	}
}
