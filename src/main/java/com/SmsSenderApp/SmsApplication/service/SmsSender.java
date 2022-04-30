package com.SmsSenderApp.SmsApplication.service;

import com.SmsSenderApp.SmsApplication.models.SmsRequest;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);


}
