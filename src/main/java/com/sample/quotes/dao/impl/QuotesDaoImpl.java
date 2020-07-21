package com.sample.quotes.dao.impl;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sample.quotes.dao.QuotesDao;
import com.sample.quotes.model.Quote;
import com.sample.quotes.model.User;
import com.sample.quotes.rowmapper.QuoteRowMapper;
import com.sample.quotes.rowmapper.UserRowMapper;

@Configuration
public class QuotesDaoImpl extends JdbcDaoSupport implements QuotesDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private QuoteRowMapper quoteRowMapper;
	
	@Autowired
	private UserRowMapper userRowMapper;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertQuote(Quote quote) {
		String insertQuoteQuery = "INSERT INTO Quotes (title,upvotes,downvotes,creator) VALUES (?,?,?,?)";
		getJdbcTemplate().update(insertQuoteQuery, new Object[] {quote.getTitle(),
				0, 0, quote.getCreator()});

	}

	@Override
	public List<Quote> getAllQuotes() {
		String getAllTaskQuery = "SELECT * FROM Quotes ORDER BY upvotes-downvotes DESC LIMIT 10";
		return getJdbcTemplate().query(getAllTaskQuery, quoteRowMapper);
	}

	@Override
	public void deleteQuote(Quote quote) {
		String deleteQuery = "DELETE FROM Quotes WHERE id=?";
		getJdbcTemplate().update(deleteQuery, quote.getId());
	}

	@Override
	public void updateQuote(Quote quote) {
		String updateQuery = "UPDATE Quotes SET title = ? WHERE id=?";
		getJdbcTemplate().update(updateQuery, new Object[] { quote.getTitle(), quote.getId() });
	}

	@Override
	public void upvoteQuote(Quote quote) {
		String upvoteQuery = "UPDATE Quotes SET upvotes = ? WHERE id=?";
		getJdbcTemplate().update(upvoteQuery, new Object[] { quote.getUpvotes(), quote.getId() });
	}

	@Override
	public void downvoteQuote(Quote quote) {
		String downvoteQuery = "UPDATE Quotes SET downvotes = ? WHERE id=?";
		getJdbcTemplate().update(downvoteQuery, new Object[] { quote.getDownvotes(), quote.getId() });
	}

	@Override
	public void insertUser(User user) {
		String getUserQuery = "SELECT * FROM quotes_user WHERE id=?";
		List<User> result = getJdbcTemplate().query(getUserQuery, new Object[] {user.getId()} , userRowMapper);
		if (result == null || result.size()==0) {
			String insertUserQuery = "INSERT INTO quotes_user (id,password) VALUES (?,?)";
			getJdbcTemplate().update(insertUserQuery, new Object[] {user.getId(),user.getPassword()});
		}
		
	}

}
