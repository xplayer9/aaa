package com.example.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
@FeignClient(
        name = "StoreToAppleClients",
        url = "apple-service:8081"
)
public interface StoreToAppleClients {

    @GetMapping("/list")
    String list();

    @PostMapping("add")
    String add(@RequestBody Map<String, String> map);
}
