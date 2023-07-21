package org.egov.user.domain.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface MsgOtpService {

    void sendOTP(String phoneNumber);
    JSONObject verifyOTP(String phoneNumber, Integer otp);
}
