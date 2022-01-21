package com.cdac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class userDaoImple implements userDao {
	
	@Autowired
	private HibernateTemplate hibernate;
	@Autowired
	private courseDao coursedao;
	@Override
	public void insertUser(final User user) {
	
		hibernate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				user.setAdminId(1);
				session.save(user);
				session.flush();
				tr.commit();
				session.close();
				return null;
				
			}
		});
		
	}
	
	@Override
	public void updateUser(final User user) {
	
		hibernate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				user.setAdminId(1);
				session.update(user);
				session.flush();
				tr.commit();
				session.close();
				return null;
				
			}
		});
		
	}
	@Override
	public boolean checkUser(final User user) {
		boolean bool = hibernate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =  session.createQuery("from User where userMail=? and userPass=?");
				q.setString(0, user.getUserMail());
				q.setString(1, user.getUserPass());
				Boolean b = !q.list().isEmpty();
				tr.commit();
				session.flush();
				session.close();
				return b;
			}
		});
		return bool;
	}
	
	  @Override
	    public String forgotPassword(final String userMail) {
	        String password = hibernate.execute(new HibernateCallback<String>() {

	            @Override
	            public String doInHibernate(Session session) throws HibernateException {
	                Transaction tr = session.beginTransaction();
	                Query q = session.createQuery("from User where userMail = ?");
	                q.setString(0, userMail);
	                List<User> li = q.list();
	                String pass = null;
	                if(!li.isEmpty())
	                    pass = li.get(0).getUserPass();
	                tr.commit();
	                session.flush();
	                session.close();
	                return pass;
	            }
	            
	        });
	        return password;
	    }
	
	
	@Override
	public List<User> selectUsers() {
		List<User> u1 = hibernate.execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =  session.createQuery("from User");
				
				List<User> b = q.list();
				tr.commit();
				session.flush();
				session.close();
				return b;
			}
		});
		return u1;
	}
	
	
	@Override
	public User selectUser(final User user) {
		User u1 = hibernate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =  session.createQuery("from User where userMail=? and userPass=?");
				q.setString(0, user.getUserMail());
				q.setString(1, user.getUserPass());
				List<User> b = q.list();
				tr.commit();
				session.flush();
				session.close();
				return b.get(0);
			}
		});
		return u1;
	}
}
