package com.sample.quotes.dao;

import java.util.List;

import com.sample.quotes.model.Quote;
import com.sample.quotes.model.User;

public interface QuotesDao {
	
	public void insertQuote(Quote quote);

	public List<Quote> getAllQuotes();

	public void deleteQuote(Quote quote);

	public void updateQuote(Quote quote);

	public void upvoteQuote(Quote quote);

	public void downvoteQuote(Quote quote);

	public void insertUser(User user);

}
