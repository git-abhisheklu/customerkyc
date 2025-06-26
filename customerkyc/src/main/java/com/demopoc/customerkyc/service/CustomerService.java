package com.demopoc.customerkyc.service;

import com.demopoc.customerkyc.domain.dto.request.CustomerRequestDTO;
import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.entity.Customer;
import com.demopoc.customerkyc.jwt.JwtUtil;
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

    public ResponseEntity<?> generateOTP(String aadhaarNo) {
        String url = "https://uat.paysprint.in/sprintverify-uat/api/v1/verification/aadhaar_sendotp";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("aadhaar_no", aadhaarNo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Token", JwtUtil.generateToken());
        headers.set("authorisedkey", "TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ==");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Make the request (String.class for raw response or define your DTO)
        ResponseEntity<?> response = restTemplate.exchange(
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
