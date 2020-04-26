package com.toto.todo.repository;

import com.toto.todo.model.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Tells Spring to bootstrap the repository during component scan.
public interface TodoRepository extends JpaRepository<Todo, Long>{

}

//  Repo for DB access JpaRep. 