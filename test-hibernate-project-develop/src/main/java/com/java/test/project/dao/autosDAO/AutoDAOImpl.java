package com.java.test.project.dao.autosDAO;

import com.java.test.project.models.Auto;
import com.java.test.project.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {
	@Override
	public Auto findById(int id) {
		Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Auto auto = session.get(Auto.class, id);
		session.close();
		return auto;
	}

	@Override
	public void save(Auto auto) {
		Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(auto);
		transaction.commit();
		session.close();
	}

	@Override
	public void update(Auto auto) {
		Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(auto);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Auto auto) {
		Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(auto);
		transaction.commit();
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Auto> findAll() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		try{
			List<Auto> allCars = (List<Auto>) session.createQuery("From Auto").list();
			session.close();
			return allCars;
		}
		catch (Exception e){
			session.close();
			return new ArrayList<>();
		}
	}
}
