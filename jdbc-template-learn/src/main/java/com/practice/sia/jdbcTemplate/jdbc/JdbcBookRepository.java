package com.practice.sia.jdbcTemplate.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.practice.sia.jdbcTemplate.db.BookRepository;
import com.practice.sia.jdbcTemplate.domain.Book;


public class JdbcBookRepository implements BookRepository {
	private static final String SELECT_ONE = "select * from books";

	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcBookRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Book findOne(Long id) {
		return jdbcTemplate.queryForObject(SELECT_ONE + " where id=?", new BookRowMapper(), id);
	}

	public static final class BookRowMapper implements RowMapper<Book> {
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String name = rs.getString("name");
			String isbn = rs.getString("isbn");

			return new Book(id, name, isbn);
		}
	}

}
