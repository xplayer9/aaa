package com.example.store;

import com.example.clients.StoreToAppleClients;
import com.example.clients.StoreToDrinkClients;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

//@AllArgsConstructor
@RestController
@RequiredArgsConstructor
public class StoreController {

    //@Autowired
    //private RestTemplate restTemplate;
    //@RequiredArgsConstructor to resolve interface non-initialized

    private final StoreToAppleClients storeToAppleClients;
    private final StoreToDrinkClients storeToDrinkClients;

    @GetMapping("/ver")
    public String ver(){
        return this.toString() + " Ver 1.1.1.10";
    }

    @PostMapping("/add")
    public String add(@RequestBody Map<String, String> map){
        String api = map.get("api");
        String msg = "API not found";
        /*
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);
        msg1 = restTemplate.exchange("http://apple-service:8081/add",
                HttpMethod.POST, entity, String.class).getBody();
        msg2 = restTemplate.exchange("http://drink-service:8083/add",
                HttpMethod.POST, entity, String.class).getBody();
         */
        if(api.equals("apple"))
            msg = storeToAppleClients.add(map);
        else if(api.equals("drink"))
            msg = storeToDrinkClients.add(map);
        return msg;
    }

    @GetMapping("/list")
    public String list(){

        /* Use restTemplate
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        String ret1 = restTemplate.exchange("http://apple-service:8081/list",
                HttpMethod.GET, entity, String.class).getBody();
        String ret2 = restTemplate.exchange("http://drink-service:8083/list",
                HttpMethod.GET, entity, String.class).getBody();
         */

        // use OpenFeign
        String ret1 = storeToAppleClients.list();
        String ret2 = storeToDrinkClients.list();
        return ret1+"<br>"+ret2;
    }
}
