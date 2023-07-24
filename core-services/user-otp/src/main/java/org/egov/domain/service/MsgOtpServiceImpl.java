package org.egov.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MsgOtpServiceImpl implements MsgOtpService {

    @Value("${sms.provider.send.url}")
    private String smsSendUrl;

    @Value("${sms.provider.verify.url}")
    private String smsverifyurl;

    @Value("${sms.auth.key}")
    private String secretKey;

    @Value("${sms.auth.template.id}")
    private String templateId;

    @Value("${sms.senderid}")
    private String senderId;

    public void sendOTP(String phoneNumber,Integer otp) {
//        https://control.msg91.com/api/v5/otp?template_id=&mobile=&otp=823723&otp_length=6
        String url = smsSendUrl + "?template_id=" + templateId + "&authkey=" + secretKey + "&mobile=91" + phoneNumber+"&otp_length=6&otp="+otp;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> responseEntity = null;
        headers.set("authkey", secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String sender = senderId;
        String requestBody = String.format("{\"sender\":\"%s\",\"route\":\"4\",\"country\":\"91\",\"sms\":[{\"to\":[\"%s\"]}]}", sender, phoneNumber);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
            System.out.println(responseEntity.getBody().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject verifyOTP(String phoneNumber, Integer otp) {
        String url = smsverifyurl + "?otp=" + otp + "&mobile=91" + phoneNumber;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("authkey", secretKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = String.format("{\"country\":\"91\",\"otp\":\"%d\",\"mobile\":\"%s\"}", otp, phoneNumber);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Object> res = null;
        JSONObject result = null;
        try {
            res = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
            ObjectMapper mapper = new ObjectMapper();
            String resString = mapper.writeValueAsString(res.getBody());
            result = new JSONObject(resString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
