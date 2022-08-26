package com.example.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
@FeignClient(
        name = "StoreToDrinkClients",
        url = "drink-service:8083"
)
public interface StoreToDrinkClients {

    @GetMapping("/list")
    String list();

    @PostMapping("add")
    String add(@RequestBody Map<String, String> map);
}
