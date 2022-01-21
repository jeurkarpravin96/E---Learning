package com.cdac.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Courses;
import com.cdac.dto.courseContent;
@Repository
public class contentDaoImple implements ContentDao {

	@Autowired
	private HibernateTemplate hibernate;
	
	@Override
	public void insertContent(final courseContent courseCnt) {
		hibernate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(courseCnt);
				tr.commit();
				session.flush();
				
				session.close();
				return null;
				
			}
		});
		
	}
	@Override
	public void deleteContent(final int courseId) {
		hibernate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				List<courseContent> c = new ArrayList<courseContent>();
				Query q = session.createQuery("from courseContent where courseId=?");
				q.setInteger(0, courseId);
				c = q.list();
				for (courseContent c1 : c) {
					session.delete(c1);
				}
				//System.out.println(courseId);
				tr.commit();
				session.flush();
				session.close();
				return null;
				
			}
		});
		
	}
	
	@Override
	public List<courseContent> selectContentList(final int courseId) {
		List<courseContent> li =  hibernate.execute(new HibernateCallback<List<courseContent>>() {

			@Override
			public List<courseContent> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				List<courseContent> c = new ArrayList<courseContent>();
				Query q = session.createQuery("from courseContent where courseId=?");
				q.setInteger(0, courseId);
				c = q.list();
				tr.commit();
				session.flush();
				session.close();
				return c;
				
			}
		});
		return li;
	}
	
	
	@Override
	public courseContent selectContent(final int contentId) {
		courseContent li =  hibernate.execute(new HibernateCallback<courseContent>() {

			@Override
			public courseContent doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				List<courseContent> c = new ArrayList<courseContent>();
				Query q = session.createQuery("from courseContent where contentId=?");
				q.setInteger(0, contentId);
				 c =  q.list();
				tr.commit();
				session.flush();
				session.close();
				return c.get(0);
				
			}
		});
		return li;
	}

	@Override
	public void updateContent(final courseContent coursecontent) {
		hibernate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				List<courseContent> c = new ArrayList<courseContent>();
				System.out.println(coursecontent);
				session.update(coursecontent);
				System.out.println(coursecontent);
				tr.commit();
				session.flush();
				session.close();
				return null;
				
			}
		});
		
	}
}
