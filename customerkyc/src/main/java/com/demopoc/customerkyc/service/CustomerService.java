package com.demopoc.customerkyc.service;

import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.entity.Customer;
import com.demopoc.customerkyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> generateOTP(String aadhaarNo) {
        String url = "https://uat.paysprint.in/sprintverify-uat/api/v1/verification/telecom/sendotp";

        // Request Body
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("aadhaar_no", aadhaarNo);  // Or "id_number" depending on API

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUb2tlbkdlbmVyYXRpb24iLCJ0aW1lc3RhbXAiOjE3NTA3NzAyMjcsInBhcnRuZXJJZCI6IkNPUlAwMDAwMjA5MyIsInByb2R1Y3QiOiJXQUxMRVQiLCJyZXFpZCI6MTEyMzk3MzA2LCJpYXQiOjE3NTA3NzAyMjcsImV4cCI6MTc1MDc3MzgyN30.qm40i-kcvevaghJhI3f3frH9cO50p_XXxegAnywU92o");
        headers.set("authorisedkey", "TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ==");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Make the request (String.class for raw response or define your DTO)
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response;
    }



//    TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ==    --> OTP validation


//    public ResponseEntity<Customer> verifyOTP( String validOTP)
//    {
//
//
//        return ResponseEntity<customer>;
//    }

}
