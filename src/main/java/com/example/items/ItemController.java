package com.example.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @Autowired ItemRepository itemRepository;

    @CrossOrigin
    @GetMapping("/additem")
    public @ResponseBody Item AddItem(@RequestParam(name = "name")String name,@RequestParam(name="description")String description){
        try {
            Item item = new Item();
            item.setName(name);
            item.setDescription(description);
            itemRepository.save(item);
            return item;
        }
        catch(Exception ex){
            return new Item();
        }
    }

    @CrossOrigin
    @GetMapping("/allitem")
    public @ResponseBody List<Item> allItem(){
        try{
           return itemRepository.findAll();
        }
        catch(Exception ex){
            return new ArrayList<>();
        }
    }

    @CrossOrigin
    @GetMapping("/finditem")
    public @ResponseBody Item findItem(@RequestParam(name = "name")String name){
        try {
            Item item = itemRepository.findById(name).get();
            return item;
        }
        catch(Exception ex){
            Item item=new Item();
            item.setDescription("item_not_found");
            return item;
        }
    }
}
