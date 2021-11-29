package com.itc.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itc.hibernateconfig.HibernateUtil;
import com.itc.model.Doctor;

public class DoctorDAO {

	public String loginCheck(Doctor dObj) {

		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			List doctors = session.createQuery("FROM Doctor").list();

			for (Iterator iterator = doctors.iterator(); iterator.hasNext();) {
				Doctor doctor = (Doctor) iterator.next();
				if ((doctor.getdId() == dObj.getdId()) && (doctor.getdName().equals(dObj.getdName()))) {
					return dObj.getdName();
				} else {
					return null;
				}
			}
			session.close();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
}
