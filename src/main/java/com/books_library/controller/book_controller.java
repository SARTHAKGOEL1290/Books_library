package com.books_library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.books_library.Entity.book;
import com.books_library.services.book_service;

@RestController
@RestControllerAdvice
public class book_controller {
	
	@Autowired
	private book_service service;
	
	@GetMapping("/books")
	public ResponseEntity<Iterable<book>> getAllbooks()
	{
		
		System.out.println("Changes on commit");
		Iterable<book> b2 =  service.findallbooks();
		try {
		 
		  if(b2== null)
		  {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  }
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	return ResponseEntity.of(Optional.of(b2));
		
	}

	@PostMapping("/add")
	public ResponseEntity<book> addnewbook(@RequestBody book b)
	{
		try {
		book b1 = service.addallbooks(b);
		
		System.out.println(b1);
		return ResponseEntity.ok(b1);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping("/books/{bid}")
	public ResponseEntity<Void> deletebook(@PathVariable("bid") int bid)
	{
		try {
		 this.service.delete_bool(bid);
		 System.out.println("book deleted");
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	@PutMapping("/books/{bid}")
	public ResponseEntity<book> update_existing(@RequestBody book bb ,@PathVariable("bid") int id)
	{
		book updated;
		
		updated =  this.service.update_info(bb,id);
		return new ResponseEntity<book>(updated,HttpStatus.CREATED);
		
		/*
		catch(Exception e)
	{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}*/
	}
	
	@GetMapping("/books/{price}")
	public ResponseEntity<Optional<book>> fetchby_price(@PathVariable("price") int amt)
	{
	    Optional<book> fees = service.getbyprice(amt);
	    System.out.println("feeeeeeeeeees"+fees);
	    return new ResponseEntity<Optional<book>>(fees,HttpStatus.FOUND);
	}
}
