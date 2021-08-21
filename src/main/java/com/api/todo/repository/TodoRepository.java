package com.api.todo.repository;

import java.util.List;

import com.api.todo.entity.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("select t from Todo t where t.workSpace.wkId = ?1")
    List<Todo> findAllTodosByWorkSpaceId(long id);
}
