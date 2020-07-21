package com.sample.quotes.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sample.quotes.model.Quote;

@Component("quoteRowMapper")
public class QuoteRowMapper implements RowMapper<Quote>{

	@Override
	public Quote mapRow(ResultSet rs, int rowNum) throws SQLException {
		Quote task = new Quote();
		task.setId(rs.getInt("id"));
		task.setCreator(rs.getString("creator"));
		task.setTitle(rs.getString("title"));
		task.setUpvotes(rs.getInt("upvotes"));
		task.setDownvotes(rs.getInt("downvotes"));
		return task;
	}

}
