package com.morimorig3.todoapp.domain.repository;

import com.morimorig3.todoapp.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
