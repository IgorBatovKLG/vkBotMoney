package com.batov.vkbotmoney.Controller;

import com.batov.vkbotmoney.Service.RequestsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallBackController {

    @PostMapping("/callback")
    public String callBack(@RequestBody String requestBody){
        RequestsService service = new RequestsService();
        service.initialVerification(requestBody);
        return "ok";
    }
}
