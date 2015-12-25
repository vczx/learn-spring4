package com.practice.sia.jdbcTemplate.db;

import com.practice.sia.jdbcTemplate.domain.Book;

public interface BookRepository {
	public Book findOne(Long id);
}
