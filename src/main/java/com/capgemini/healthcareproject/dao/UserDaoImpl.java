package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcareproject.dto.User;
import com.capgemini.healthcareproject.exception.UserException;


@Repository
public class UserDaoImpl implements UserDao {

	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean registerUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(user);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new UserException("User Cannot be Added Please Enter Unique  Id");
	}

	@Override
	public User loginUser(User user) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from User where userId=:uId ";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("uId", user.getUserId());
		try {
			User userAccount = query.getSingleResult();
			if (userAccount.getUserPassword().equals(user.getUserPassword())) {
				return userAccount;
			}
		} catch (Exception e) {
		}
		throw new UserException("Invalid User Account please Enter Valid Credentials");


}

	@Override
	public boolean updateUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update User set userName = :uname, userPassword=: pass, userId=: uId, userRole=:urole, gender=:gender, age=: age where userEmail = :email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("uname", user.getUserName());
		query.setParameter("pass", user.getUserPassword());
		query.setParameter("email", user.getUserEmail());
		query.setParameter("urole", user.getUserRole());
		query.setParameter("gender", user.getGender());
		query.setParameter("age", user.getAge());
		query.setParameter("uId", user.getUserId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new UserException("Sorry User cannot be  Modified ");
	}

	@Override
	public ArrayList<User> getAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from User ";
		Query query = entityManager.createQuery(jpql, User.class);
		ArrayList<User> user = (ArrayList<User>) query.getResultList();
		if (user != null && user.size() != 0) {
			return user;

		}
		throw new UserException("User Details Are not Present ");
	}

	@Override
	public boolean deleteUser(String userEmail) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from User where userEmail = :email ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", userEmail);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new UserException("Cannot be deleted Enter Valid Email Id");
	}
}
