package com.java.test.project.dao.usersDao;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;
import com.java.test.project.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

    @Override
    public User findById(Integer id) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void save(User user) {
        Transaction transObj = null;
        Session session = null;
        try{
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        transObj = session.beginTransaction();
        session.save(user);
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
    public void update(User user) {
        Transaction transObj = null;
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            transObj = session.beginTransaction();
            session.update(user);
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
    public void delete(User user) {
        Transaction transObj = null;
        Session session = null;
        try{
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        transObj = session.beginTransaction();
        session.delete(user);
        transObj.commit();}
       catch (HibernateException exObj){
                HibernateSessionFactoryUtil.catchException(transObj, exObj);
            }
		finally {
                session.close();
            }
    }

    @Override
    public Auto findAutoById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Auto auto = session.get(Auto.class, id);
        session.close();

        return auto;
    }

    @Override
    public void changeName(String newName) {
        List<User> allUsers = findAll();
        Session session = null;
        Transaction transObj = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            transObj = session.beginTransaction();

            allUsers.stream()
                    .filter(user -> (user.getId() % 5) == 0)
                    .forEach(user -> user.setName(newName));
            for (User everyUser : allUsers) {
                session.update(everyUser);
            }
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
    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("From User").list();
        session.close();
        return users;
    }
}
