package com.practice.sia.hibernate.db;

import com.practice.sia.hibernate.domain.Book;

public interface BookRepository {
	public Book findOne(Long id);
}
