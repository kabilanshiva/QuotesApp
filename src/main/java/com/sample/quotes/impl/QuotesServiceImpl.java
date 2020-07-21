package com.sample.quotes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sample.quotes.dao.QuotesDao;
import com.sample.quotes.model.Quote;
import com.sample.quotes.model.User;
import com.sample.quotes.service.QuotesService;

@CrossOrigin(origins = "*")
@RestController
public class QuotesServiceImpl implements QuotesService {

	@Autowired
	private QuotesDao quotesDao;

	@Override
	public void insertQuote(Quote quote) {
		quotesDao.insertQuote(quote);
	}

	@Override
	public ResponseEntity<List<Quote>> getAllQuotes() {
		return new ResponseEntity<List<Quote>>(quotesDao.getAllQuotes(), HttpStatus.OK);
	}

	@Override
	public void deleteQuote(Quote quote) {
		quotesDao.deleteQuote(quote);
	}

	@Override
	public void updateQuote(Quote quote) {
		quotesDao.updateQuote(quote);
	}

	@Override
	public void upvoteQuote(Quote quote) {
		quotesDao.upvoteQuote(quote);
	}

	@Override
	public void downvoteQuote(Quote quote) {
		quotesDao.downvoteQuote(quote);
	}

	@Override
	public void insertUser(User user) {
		quotesDao.insertUser(user);
	}

}
