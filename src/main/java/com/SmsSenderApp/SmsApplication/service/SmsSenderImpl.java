package com.SmsSenderApp.SmsApplication.service;

import com.SmsSenderApp.SmsApplication.TwilioConfig;
import com.SmsSenderApp.SmsApplication.models.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import static com.SmsSenderApp.SmsApplication.TwilioInitializer.LOGGER;

@Service("twilio")
public class SmsSenderImpl implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSenderImpl.class);

    private final TwilioConfig twilioConfig;

    @Autowired
    public SmsSenderImpl(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}" + smsRequest);
        } else
            {
            throw new IllegalArgumentException("phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number ");
        }
    }


    private boolean isPhoneNumberValid(String phoneNumber) {

        return true;
    }

}