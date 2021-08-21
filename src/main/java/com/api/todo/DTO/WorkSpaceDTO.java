package com.api.todo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaceDTO {
    
    private long workSpaceId;
    private String name;
    private long userId;
}
