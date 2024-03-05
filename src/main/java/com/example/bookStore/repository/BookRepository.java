package com.example.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookStore.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
