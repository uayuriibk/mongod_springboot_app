package com.yuriib.springboot.mongodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Getter
@Setter
@AllArgsConstructor
public class ItemReview {

    @NonNull
    @TextIndexed
    private String userName;

    @NonNull
    private int mark;

}
