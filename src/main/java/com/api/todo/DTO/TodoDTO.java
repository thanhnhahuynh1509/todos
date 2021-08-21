package com.api.todo.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    
    private long todoId;
    private String content;
    private Date date;
    private boolean status;

    private long workSpaceId;

}
