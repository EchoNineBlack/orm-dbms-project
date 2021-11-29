package com.itc.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itc.hibernateconfig.HibernateUtil;
import com.itc.model.Patient;

public class PatientDAO {

	/* Method to CREATE a patient in the database */
	public boolean addPatient(Patient pObj /* int pid,String pname, String dept, String doctor */) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Patient patient = new Patient();
			patient.setpId(pObj.getpId());
			patient.setpName(pObj.getpName());
			patient.setDept(pObj.getDept());
			patient.setDoctor(pObj.getDoctor());
			Integer i = (Integer) session.save(patient);
			tx.commit();
			if (i > 0)
				return true;
			else
				return false;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	/* Method to READ all the patients */
	public LinkedList listPatient() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		LinkedList patients = new LinkedList();
		try {
			tx = session.beginTransaction();
			List arr_patient = session.createQuery("FROM Patient").list();

			for (int i = 0; i < arr_patient.size(); i++)
				patients.add(arr_patient.get(i));

			/*
			 * for (Iterator iterator = patients.iterator(); iterator.hasNext();) { Patient
			 * patient = (Patient) iterator.next(); System.out.print("patient ID: " +
			 * patient.getpId()+"\t"); System.out.print("patient Name: " +
			 * patient.getpName()+"\t"); System.out.print("department: " +
			 * patient.getDept()+"\t"); System.out.print("doctor name: " +
			 * patient.getDoctor()+"\n");
			 */

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return patients;
	}

	/* Method to UPDATE doctor for a patient */
	public boolean updatePatient(Patient pObj /* Integer pId,String doctor */ ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		boolean updateFlag = false;
		try {
			tx = session.beginTransaction();
			Patient patient = (Patient) session.get(Patient.class, pObj.getpId());
			if (patient != null)
				updateFlag = true;
			patient.setDoctor(pObj.getDoctor());
			session.update(patient);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return updateFlag;
	}

	/* Method to DELETE a patient from the records */
	public boolean deletePatient(Patient pObj /* Integer pId */) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		boolean deleteflag = false;
		try {
			tx = session.beginTransaction();
			Patient patient = (Patient) session.get(Patient.class, pObj.getpId());
			if (patient != null)
				deleteflag = true;
			session.delete(patient);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return deleteflag;
	}

}