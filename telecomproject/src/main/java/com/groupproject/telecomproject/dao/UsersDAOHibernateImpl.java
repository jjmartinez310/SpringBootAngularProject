package com.groupproject.telecomproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.groupproject.telecomproject.entity.Users;

@Repository
public class UsersDAOHibernateImpl implements UsersDAO {
    
    // define field for entitymanager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public UsersDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
	public List<Users> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Users> theQuery =
				currentSession.createQuery("from Users", Users.class);
		
		// execute query and get result list
		List<Users> users = theQuery.getResultList();
		
		// return the results		
		return users;
	}

    @Override
    public Users findById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // get the user
        Users user = 
            currentSession.get(Users.class, id);
        //return the user
        return user;
    }

    @Override
    public void save(Users user) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //save user
        currentSession.saveOrUpdate(user); // saveOrUpdate method works like this: if id=0 then save, else update
        
    }

    @Override
    public void deleteById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object witht he primary key
        Query theQuery =
            currentSession.createQuery("delete from Users where id=:userid");
            theQuery.setParameter("userid", id);
            theQuery.executeUpdate();
    }

}
