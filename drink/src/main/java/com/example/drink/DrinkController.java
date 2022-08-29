package com.example.drink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class DrinkController {

    @Autowired
    DrinkRepository rep;

    @GetMapping("/ver")
    public String ver(){
        return this.toString() + " Ver 1.1.1.2";
    }

    @GetMapping("/list")
    public String list(){
        StringBuilder sb = new StringBuilder();
        for(DrinkTableData n: rep.findAll()){
            sb.append(n.kind).append(" ");
            sb.append(" Price ").append(n.price);
            sb.append(" Quantity ").append(n.quantity).append("<br>");
        }
        return sb.toString();
    }

    @PostMapping("add")
    public String add(@RequestBody Map<String, String> map){
        DrinkTableData one = DrinkTableData.builder()
                .kind(map.get("kind"))
                .price(Double.parseDouble(map.get("price")))
                .quantity(Integer.parseInt(map.get("quantity")))
                .build();
        rep.save(one);
        return one.kind+" saved successfully !!!";
    }

    @GetMapping("/del")
    public Integer del(@RequestParam String name) {
        int count = 0;
        for(DrinkTableData n: rep.findAll()){
            if(n.getKind() == null || n.getKind().equals(name)) {
                rep.delete(n);
                count++;
            }
        }
        return count;
    }
}
