package com.yuriib.springboot.mongodapp.controller;

import com.yuriib.springboot.mongodapp.model.Item;
import com.yuriib.springboot.mongodapp.model.ItemPriority;
import com.yuriib.springboot.mongodapp.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("items/api")
@AllArgsConstructor
public class ItemController {

    private ItemRepository itemRepository;

    @PostMapping
    public void insert(@RequestBody Item item){
        itemRepository.insert(item);
    }

    @PutMapping
    public void update(@RequestBody Item item){
        itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        itemRepository.deleteById(id);
    }

    @GetMapping("/all")
    public Collection<Item> all(){
        Sort sortByGroupAsc = Sort.by("group").ascending();
        Collection<Item> items = itemRepository.findAll(sortByGroupAsc);
        return items;
    }

    @GetMapping("/{id}")
    public Item byId(@PathVariable String id){
        Item item = itemRepository.findById(id).orElse(null);
        return item;
    }

    @GetMapping("/byGroup/{group}")
    public Collection<Item> byGroup(@PathVariable String group){
        Sort sortByGroupAsc = Sort.by("group").ascending();
        return itemRepository.findAllByGroupContains(group, sortByGroupAsc);
    }

    @GetMapping("highThatStartWithM")
    public Collection<Item> highThatStartWithM(){
        return itemRepository.findAllByPriorityAndNameStartsWith(ItemPriority.HIGH, "M");
    }

}
