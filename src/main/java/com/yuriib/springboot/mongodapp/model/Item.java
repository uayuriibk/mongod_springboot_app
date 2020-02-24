package com.yuriib.springboot.mongodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "items")
public class Item {

    @Id
    private String id;

    @TextIndexed
    private String name;

    private ItemPriority pritority;

    @TextIndexed
    @Indexed(direction = IndexDirection.ASCENDING)
    private String group;

    private Collection<ItemReview> reviews = new ArrayList<>();

    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    @DBRef
    private PaymentOptions paymentOptions;

    protected Item(){}

}
