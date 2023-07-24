package org.egov.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface MsgOtpService {

    void sendOTP(String phoneNumber,Integer otp);
    JSONObject verifyOTP(String phoneNumber, Integer otp);
}
