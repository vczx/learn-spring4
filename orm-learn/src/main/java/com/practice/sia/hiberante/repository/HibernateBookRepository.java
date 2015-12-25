package com.practice.sia.hiberante.repository;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.practice.sia.hibernate.domain.Book;

@Repository
public class HibernateBookRepository {
	
	private SessionFactory sessionFactory;

	@Inject
	public HibernateBookRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Book findOne(long id){
		return (Book) currentSession().get(Book.class, id);
	}
	
}
