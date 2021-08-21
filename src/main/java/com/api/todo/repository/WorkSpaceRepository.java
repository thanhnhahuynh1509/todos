package com.api.todo.repository;

import java.util.List;

import com.api.todo.entity.WorkSpace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSpaceRepository extends JpaRepository<WorkSpace, Long> {

    @Query("select w from WorkSpace w where w.user.username = ?1")
    List<WorkSpace> findAllWorkSpacesByUsername(String username);
}
