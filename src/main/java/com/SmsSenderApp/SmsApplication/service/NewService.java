package com.SmsSenderApp.SmsApplication.service;

import com.SmsSenderApp.SmsApplication.models.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NewService  {

    private final SmsSender smsSender;

    @Autowired
    public NewService(@Qualifier("twilio") SmsSenderImpl smsSender) {
        this.smsSender = smsSender;
    }


    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);

    }
}
