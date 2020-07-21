package com.sample.quotes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.quotes.model.Quote;
import com.sample.quotes.model.User;

@CrossOrigin(origins = "*")
public interface QuotesService {
	
	@PutMapping("/quotes")
	public void insertQuote(@RequestBody Quote quote);
	
	@PutMapping("/quotes/user")
	public void insertUser(@RequestBody User user);
	
	@PostMapping("/quotes")
	public void updateQuote(@RequestBody Quote quote);
	
	@PostMapping("/quotes/upvote")
	public void upvoteQuote(@RequestBody Quote quote);
	
	@PostMapping("/quotes/downvote")
	public void downvoteQuote(@RequestBody Quote quote);
	
	@GetMapping("/quotes")
	public ResponseEntity<List<Quote>> getAllQuotes();
	
	@PostMapping("/quotes/delete")
	public void deleteQuote(@RequestBody Quote quote);

}
