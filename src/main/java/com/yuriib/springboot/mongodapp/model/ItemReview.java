package com.yuriib.springboot.mongodapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Getter
@Setter
@AllArgsConstructor
public class ItemReview {

    @TextIndexed
    private String userName;

    private int mark;

}
