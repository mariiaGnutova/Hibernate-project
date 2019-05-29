package com.java.test.project.dao.autosDAO;

import com.java.test.project.models.Auto;
import com.java.test.project.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {
	@Override
	public Auto findById(Integer id) {
		Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		Auto auto = session.get(Auto.class, id);
		session.close();
		return auto;
	}

	@Override
	public void save(Auto auto) {
		Transaction transObj = null;
		Session session = null;
		try{
		session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
			transObj = session.beginTransaction();
		session.save(auto);
			transObj.commit();}
		catch (HibernateException exObj){
			HibernateSessionFactoryUtil.catchException(transObj, exObj);
		}
		finally {
			session.close();
		}
	}

	@Override
	public void update(Auto auto) {
		Transaction transObj = null;
		Session session = null;
		try{
		session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		transObj = session.beginTransaction();
		session.update(auto);
		transObj.commit();
		}
		catch (HibernateException exObj){
			HibernateSessionFactoryUtil.catchException(transObj, exObj);
		}
		finally {
			session.close();
		}
	}

	@Override
	public void delete(Auto auto) {
		Transaction transObj = null;
		Session session = null;
		try{
		session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
		transObj = session.beginTransaction();
		session.delete(auto);
		transObj.commit();}
		catch (HibernateException exObj){
			HibernateSessionFactoryUtil.catchException(transObj, exObj);
		}
		finally {
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Auto> findAll() {
		Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		List<Auto> allCars = (List<Auto>) session.createQuery("From Auto").list();
		session.close();
		return allCars;
	}
}
