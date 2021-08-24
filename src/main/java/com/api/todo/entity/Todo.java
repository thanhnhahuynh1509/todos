package com.api.todo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Todo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoId;
    private String content;
    private Date date;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "workSpace_id")
    private WorkSpace workSpace;
}
