package com.practice.sia.hibernate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.practice.sia.hiberante.repository.HibernateBookRepository;
import com.practice.sia.hibernate.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HibernateBookRepositoryTest{
	
	@Autowired
	HibernateBookRepository hibernateBookRepository;
	
	@Test
	@Transactional
	public void findOne() throws InterruptedException{
		assertBook(0, hibernateBookRepository.findOne(1L));
		assertBook(1, hibernateBookRepository.findOne(2L));
		//Thread.sleep(500000);
	}
	
	private static final Book[] BOOKS = new Book[2];
	
	@BeforeClass
	public static void before(){
		BOOKS[0] = new Book(1L,"java","isbn1");
		BOOKS[1] = new Book(2L,"ajax","isbn2");
	}
	
	public static void assertBook(int expectedIndex, Book acutal){
		Book expected = BOOKS[expectedIndex];
		assertEquals(expected.getId(), acutal.getId());
		assertEquals(expected.getName(), acutal.getName());
		assertEquals(expected.getIsbn(), acutal.getIsbn());
	}
}
