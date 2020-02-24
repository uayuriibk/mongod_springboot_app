package com.yuriib.springboot.mongodapp.repository;

import com.yuriib.springboot.mongodapp.model.Item;
import com.yuriib.springboot.mongodapp.model.ItemPriority;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    Collection<Item> findAllByGroupContains(String group, Sort sort);

    Collection<Item> findAllByPriorityAndNameStartsWith(ItemPriority itemPriority, String name);

    Collection<Item> findAllBy(TextCriteria textCriteria);

}
