package com.yuriib.springboot.mongodapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Document(collection = "items")
public class Item {

    @Id
    private String id;

    @NonNull
    @TextIndexed
    private String name;

    @NonNull
    private ItemPriority priority;

    @NonNull
    @TextIndexed
    @Indexed(direction = IndexDirection.ASCENDING)
    private String group;

    @NonNull
    private Collection<ItemReview> reviews = new ArrayList<>();

    @NonNull
    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    @NonNull
    @DBRef
    private PaymentOptions paymentOptions;

    protected Item(){}

    public Item(
            String name,
            ItemPriority priority,
            String group,
            DeliveryInfo deliveryInfo,
            List<ItemReview> reviewsList,
            PaymentOptions creditCardPayment) {
    }
}
