package com.books_library.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books_info")
public class book {
	
	@Id
	public int bid;
	@Column(name = "name")
	public String name;
	@Column(name = "subject")
	public String subject;
	@Column(name = "author")
	public String author;
	@Column(name = "price")
	public int price;
	@Column(name= "shelf")
	public String shelf_no;
	
	public book(int bid, String name, String subject, String author, int price, String shelf_no) {
		super();
		this.bid = bid;
		this.name = name;
		this.subject = subject;
		this.author = author;
		this.price = price;
		this.shelf_no = shelf_no;
	}

	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getShelf_no() {
		return shelf_no;
	}

	public void setShelf_no(String shelf_no) {
		this.shelf_no = shelf_no;
	}

	@Override
	public String toString() {
		return "book [bid=" + bid + ", name=" + name + ", subject=" + subject + ", author=" + author + ", price="
				+ price + ", shelf_no=" + shelf_no + "]";
	}

	
	
	
	
	

}
