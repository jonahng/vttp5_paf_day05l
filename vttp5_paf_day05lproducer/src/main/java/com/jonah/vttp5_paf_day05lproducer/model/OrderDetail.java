package com.jonah.vttp5_paf_day05lproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private int id;

    private String productName;
    private int price;
    private int quantity;
    
}
