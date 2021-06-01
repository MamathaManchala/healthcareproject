package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcareproject.dto.DiagnosticCenter;
import com.capgemini.healthcareproject.exception.CenterException;
import com.capgemini.healthcareproject.exception.TestException;

@Repository
public class DiagnosticCenterDaoImpl implements DiagnosticCenterDao {


	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(center);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new CenterException("Test Cannot be Added ");
	}

	@Override
	public boolean deleteCenter(int centerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from DiagnosticCenter where centerId = : cId ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cId", centerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new CenterException("Center Cannot be deleted ");
	}

	@Override
	public boolean updateCenter(DiagnosticCenter center) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update DiagnosticCenter set centerName = :cName, centerId=:cId where centerId=:cId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cId", center.getCenterId());
		query.setParameter("cName", center.getCenterName());
		
		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new TestException("Sorry Center cannot be  Modified ");
	}


	@Override
	public ArrayList<DiagnosticCenter> getAllCenter() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from DiagnosticCenter ";
		Query query = entityManager.createQuery(jpql, DiagnosticCenter.class);
		ArrayList<DiagnosticCenter> centerList = (ArrayList<DiagnosticCenter>) query.getResultList();
		if (centerList != null && centerList.size() != 0) {
			return centerList;
		}
		throw new CenterException("Center Details Are not Present ");

	}

}
