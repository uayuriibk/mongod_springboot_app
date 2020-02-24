package com.yuriib.springboot.mongodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DeliveryInfo {

    private LocalDate deliveryDate;

    private int deliveryFee;

    private boolean inStock;

}
