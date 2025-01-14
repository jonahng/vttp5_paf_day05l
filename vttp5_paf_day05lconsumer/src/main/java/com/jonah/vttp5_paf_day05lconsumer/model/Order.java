package com.jonah.vttp5_paf_day05lconsumer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;

    private String fullName;

    private List<OrderDetail> lineItem;
    
}
