package com.example.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookStore.entity.MyBookList;

public interface MybookRepository extends JpaRepository<MyBookList,Long> {

}
