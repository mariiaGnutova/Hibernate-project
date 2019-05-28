package com.java.test.project.services.autoService;

import com.java.test.project.models.Auto;

import java.util.List;

public interface AutoService {
	Auto findById(Integer id);
	void save(Auto auto);
	void update(Auto auto);
	void delete(Auto auto);
	List<Auto> findAllAutos();
}
