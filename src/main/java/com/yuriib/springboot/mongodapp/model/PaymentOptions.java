package com.yuriib.springboot.mongodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@Document
public class PaymentOptions {

    @Id
    private String id;

    private PaymentType type;

    private int fee;

}
