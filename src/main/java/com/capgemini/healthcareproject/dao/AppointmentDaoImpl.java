package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcareproject.dto.Appointment;
import com.capgemini.healthcareproject.exception.AppointmentException;
import com.capgemini.healthcareproject.exception.TestException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(appointment);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new AppointmentException("Appointment Cannot be Added ");
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Appointment where appointmentId = : aId ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("aId", appointmentId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new TestException("appointment Cannot be deleted ");
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Appointment set userId=:uId, appointmentDate=:aDate, appointmentTime=:aTime where appointmentId=:aId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("uId", appointment.getUserId());
		query.setParameter("aDate", appointment.getAppointmentDate());
		query.setParameter("aTime", appointment.getAppointmentId());
		query.setParameter("aId", appointment.getAppointmentId());
		
		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new TestException("Sorry appointment cannot be  Modified ");
	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Appointment ";
		Query query = entityManager.createQuery(jpql, Appointment.class);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		throw new TestException("Appointment Details Are not Present ");

	}

}
