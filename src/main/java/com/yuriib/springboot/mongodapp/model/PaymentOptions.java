package com.yuriib.springboot.mongodapp.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@RequiredArgsConstructor
@Document
public class PaymentOptions {

    @Id
    private String id;

    @NonNull
    private PaymentType type;

    @NonNull
    private int fee;

}
