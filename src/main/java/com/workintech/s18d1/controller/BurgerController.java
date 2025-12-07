package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDoa;


    public BurgerController(BurgerDao burgerDoa) {
        this.burgerDoa = burgerDoa;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDoa.save(burger);

    }
    @GetMapping
    public List<Burger> findAll(){
        return burgerDoa.findAll();
    }

    @GetMapping("/{id}")
    public Burger find(@PathVariable long id){
        return burgerDoa.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDoa.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable long id){
        return burgerDoa.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> getByBreadType(@PathVariable("breadType") String breadType){
        BreadType btEnum = BreadType.valueOf(breadType);
        return burgerDoa.findByBreadType(btEnum);
    }

    @GetMapping("/price/{price}")
    public List<Burger> getByPrice(@PathVariable("price") Integer price){
        return burgerDoa.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> getByContent(@PathVariable("content") String content){
        return burgerDoa.findByContent(content);
    }

}
