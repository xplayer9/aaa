package com.example.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        name = "StoreToAppleClients",
        url = "apple-service"
)
public interface StoreToAppleClients {

    @GetMapping("/list")
    String list();

    @PostMapping("add")
    String add(@RequestBody Map<String, String> map);

    @GetMapping("/del")
    Integer del(@RequestParam String name);
}
