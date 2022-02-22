package com.books_library.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books_library.Dao.books_dao;
import com.books_library.Entity.book;

@Service
public class book_service {
	
	@Autowired
	private books_dao repo;
	
	book b;
	
	
	public Iterable<book> findallbooks()
	{
		//Optional<Integer> list_book = Optional.of(b.bid);
		System.out.println("---------------");
		Iterable<book> list_book = repo.findAll();
		System.out.println("hello"+list_book);
		return list_book;
		
	}
	
	public book addallbooks(book b)
	{
		book Book = repo.save(b);
		return Book; 
	}

	public void delete_bool(int bid) {
		
	      repo.deleteById(bid);
		
	}

/*	public Optional<book> change_data(int id) {
		// TODO Auto-generated method stub
		
		
	//	Optional<book> b9 = repo.findById(id);
		
		Optional<book> b8 = repo.findById(id);
		
		b8.stream();
		
	//  b9.stream().filter(bo->bo.name=="GOF").forEach(bo->bo.setPrice(5000));
		System.out.println("---------------" + b8);
		return b8;
		
	}
*/
	
	public book update_info(book bb, int id) {
		// TODO Auto-generated method stub
	/*	List<book> st = new ArrayList<>();
		st.add(new book(11,"headfirst","java","john",500,"B6"));
		st.add(new book(12,"GOF","java_design","rick",1500,"B9"));
		
		book ref = new book(13,"GOF","java_design","rick",1500,"B9");
		System.out.println("_______________>>>>>>>>>");
		
		st = st.stream().map(e->{
			
			if(e.bid==id)
				ref.setPrice(bb.getPrice());
			repo.save(e);
			return e;
		}).collect(Collectors.toList());
		*/
		book b7 = repo.find_BookById(id);
	          
	          
			//throw new NoSuchElementException();
		
		b7.setPrice(bb.getPrice());
		repo.save(b7);
		System.out.println(b7);
	
		
			return b7;	
		
		
	}
	// demonstarting the use of optional 
	public Optional<book> getbyprice(int amt)
	{
		Optional<book> b9 = repo.findByPrice(amt);
		System.out.println("==================");
    //    b9.stream().filter(i->i.getPrice()==3500).forEach(e->System.out.println(e));
		
		b9.stream().filter(i->i.getPrice()==3500).findAny().orElseThrow(()->new NullPointerException());
	    System.out.println("-----------------------");
        b9.ifPresent(System.out::println);
		
		return b9;
	}
	

}
