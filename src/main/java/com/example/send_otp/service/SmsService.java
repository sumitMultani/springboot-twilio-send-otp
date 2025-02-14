package com.example.send_otp.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// SMS Service (Using Twilio)
@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public void sendOtp(String phoneNumber, String otp) {
        Twilio.init(accountSid, authToken);
        String phnoeNumberr =  "+"+phoneNumber;
        Message.creator(
                new com.twilio.type.PhoneNumber(phnoeNumberr),
                new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                "Your OTP code is Generated successfully."
        ).create();
    }
}

