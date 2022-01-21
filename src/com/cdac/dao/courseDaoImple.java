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
@Repository
public class courseDaoImple implements courseDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertCourse(final Courses course) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(course);
				tr.commit();
				session.flush();
				
				session.close();
				return null;
			}
			
			
		});
		
	}

	@Override
	public void deleteCourse(final int courseId ) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Courses(courseId));
				tr.commit();
				session.flush();
				
				session.close();
				return null;
			}
			
			
		});
		
	}

	@Override
	public void updateCourse(final Courses course) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				System.out.println(course);
				session.update(course);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
			
		});
		
	}

	@Override
	public List<Courses> selectAllCourses() {
		List<Courses> li =  hibernateTemplate.execute(new HibernateCallback<List<Courses>>() {

			@Override
			public List<Courses> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Courses order by courseId desc");
				List<Courses> l = q.list();
				tr.commit();
				session.flush();
				
				session.close();
				return l;
			}
			
			
		});
		return li;
	}

	@Override
	public List<Courses> selectByUserId(final int userId) {
		List<Courses> li =  hibernateTemplate.execute(new HibernateCallback<List<Courses>>() {

			@Override
			public List<Courses> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("select courseId from userId_courseId where userId=?");
				q.setInteger(0, userId);
				List<Integer> courseIdList = q.list();
				List<Courses> courseList = new ArrayList<>();
				for (Integer i : courseIdList) {
					Query q1 = session.createQuery("from Courses where courseId=?");
					q1.setInteger(0, i);
					courseList.add((Courses)q1);
				}
				tr.commit();
				session.flush();
				
				session.close();
				return courseList;
			}
			
		});
		return li;
	}

	@Override
	public Courses selectByCourseId(final int courseId) {
		Courses c = hibernateTemplate.execute(new HibernateCallback<Courses>() {

			@Override
			public Courses doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				 Courses c1 = (Courses) session.get(Courses.class, courseId);
				 tr.commit();
				 session.flush();
				session.close();
				return c1;
			}
			
			
		});
		return c;
	}

	@Override
	public List<Courses> searchCourse(final String courseName) {
		List<Courses> li =  hibernateTemplate.execute(new HibernateCallback<List<Courses>>() {

			@Override
			public List<Courses> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Courses where courseName like '% ? %' ");
				q.setString(0, courseName);
				List<Courses> l = q.list();
				tr.commit();
				session.flush();
				
				session.close();
				return l;
			}
			
			
		});
		return li;
		
	}
	

}
