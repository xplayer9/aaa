package com.example.apple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class AppleController {

    @Autowired
    AppleRepository rep;

    @GetMapping("/ver")
    public String ver(){
        return this.toString() + " Ver 1.1.1.4";
    }

    @GetMapping("/list")
    public String list(){
        StringBuilder sb = new StringBuilder();
        for(AppleTableData n: rep.findAll()){
            sb.append(n.model).append(" ");
            sb.append(" Price ").append(n.price);
            sb.append(" Quantity ").append(n.quantity).append("<br>");
        }
        return sb.toString();
    }

    @PostMapping("add")
    public String add(@RequestBody Map<String, String> map){
        AppleTableData one = AppleTableData.builder()
                .model(map.get("model"))
                .price(Double.parseDouble(map.get("price")))
                .quantity(Integer.parseInt(map.get("quantity")))
                .build();
        rep.save(one);
        return one.model+" saved successfully !!!";
    }
}
