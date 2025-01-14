package com.jonah.vttp5_paf_day05lconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //this can be done with source action and make getters setters and constructors
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String taskName;
    
}
