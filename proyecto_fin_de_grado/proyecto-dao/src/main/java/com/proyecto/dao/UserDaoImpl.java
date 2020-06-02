
package com.proyecto.dao;

import java.util.Collection;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.proyecto.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	
	

	public User findByEmail(String email) {
		try{
			User user = (User) getEntityManager()
					.createQuery("SELECT u FROM User u WHERE u.email = :email")
					.setParameter("email", email)
					.getSingleResult();
			return user; 
		}catch(NoResultException ex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
				.getResultList();
		return users;
	}

	public User save(User user) {
		User u1 = findByEmail(user.getEmail());
		if (u1 == null) {
			persist(user);
		}
		return u1;
	}

	public void deleteByEmail(String email) {
		User user = (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.email = :email")
				.setParameter("email", email)
				.getSingleResult();
		delete(user);
	}
	
	//An alternative to Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
	    if(collection == null) {
	        return;
	    }
	    collection.iterator().hasNext();
	}

}