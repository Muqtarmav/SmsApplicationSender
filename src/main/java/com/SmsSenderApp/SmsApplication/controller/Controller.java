package com.SmsSenderApp.SmsApplication.controller;

import com.SmsSenderApp.SmsApplication.models.SmsRequest;
import com.SmsSenderApp.SmsApplication.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {


    private final NewService newService;

    @Autowired
    public Controller(NewService newService){
        this.newService = newService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        newService.sendSms(smsRequest);

    }
}
