package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcareproject.dto.Test;
import com.capgemini.healthcareproject.exception.TestException;

@Repository
public class TestDaoImpl implements TestDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addTest(Test test) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(test);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new TestException("Test Cannot be Added ");
	}

	@Override
	public boolean deleteTest(int testId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Test where testId = : tId ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tId", testId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new TestException("Test Cannot be deleted ");
	}

	@Override
	public boolean updateTest(Test test) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Test set testName = :tName, testId=:tId where testId=:tId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tId", test.getTestId());
		query.setParameter("tName", test.getTestName());
		
		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new TestException("Sorry Test cannot be  Modified ");
	}

	@Override
	public ArrayList<Test> getAllTest() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Test ";
		Query query = entityManager.createQuery(jpql, Test.class);
		ArrayList<Test> testList = (ArrayList<Test>) query.getResultList();
		if (testList != null && testList.size() != 0) {
			return testList;
		}
		throw new TestException("Test Details Are not Present ");

	}

	
}
