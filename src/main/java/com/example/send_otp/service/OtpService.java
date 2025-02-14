package com.example.send_otp.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    private final Map<String, String> otpStorage = new HashMap<>();
    private final Random random = new SecureRandom();

    public String generateOtp(String key) {
        String otp = String.format("%06d", random.nextInt(1000000));
        otpStorage.put(key, otp);
        return otp;
    }

    public boolean validateOtp(String key, String otp) {
        return otp.equals(otpStorage.getOrDefault(key, ""));
    }
}

