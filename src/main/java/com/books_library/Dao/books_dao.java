package com.books_library.Dao;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.books_library.Entity.book;

public interface books_dao extends CrudRepository<book,Integer> {

	@Query("select b from book b where b.bid= :bid")
	public book find_BookById(@PathParam("bid") int bid);
	//public book deleteById();
	

	public Optional<book> findByPrice(int price);
	
	//public Optional<book> findBookOptional(int bid);

}
