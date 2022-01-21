package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Admin;

@Repository
public class adminDaoImple  implements adminDao{

	@Autowired
	private HibernateTemplate hibernate;
	
	@Override
	public boolean checkAdmin(final Admin admin) {
		boolean bool = hibernate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =  session.createQuery("from Admin where adminMail=? and adminPass=?");
				q.setString(0, admin.getAdminMail());
				q.setString(1, admin.getAdminPass());
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
	public Admin getAdmin(final Admin admin) {
		Admin bool = hibernate.execute(new HibernateCallback<Admin>() {

			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q =  session.createQuery("from Admin where adminMail=? and adminPass=?");
				
				q.setString(0, admin.getAdminMail());
				q.setString(1, admin.getAdminPass());
				
				List<Admin> b =  q.list();
				System.out.println(b.get(0));
				System.out.println("Hello");
				tr.commit();
				session.flush();
				session.close();
				return b.get(0);
			}
		});
		return bool;
	}
}

