package com.sample.quotes.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sample.quotes.model.Quote;
import com.sample.quotes.model.User;

@Component("userRowMapper")
public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}