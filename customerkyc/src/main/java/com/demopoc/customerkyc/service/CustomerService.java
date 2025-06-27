package com.demopoc.customerkyc.service;

import com.demopoc.customerkyc.domain.dto.request.CustomerRequestDTO;
import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.domain.dto.response.Root;
import com.demopoc.customerkyc.entity.Customer;
import com.demopoc.customerkyc.jwt.JwtUtil;
import com.demopoc.customerkyc.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;



    public Root generateOTP(String id_number) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://uat.paysprint.in/sprintverify-uat/api/v1/verification/aadhaar_sendotp";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("id_number", id_number);
        System.out.println("Aadhaar no."+ id_number);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorisedkey", "TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ=="); // Example custom header
        headers.set("Token", JwtUtil.generateToken()); // If needed

        HttpEntity<Map<String,String>> entity = new HttpEntity<>(requestBody, headers);
        System.out.println("Aadhaar no. request body"+ requestBody);

        //TODO: add interceptors or Encoder Decoder to check Requestbody before sending it through client
        ResponseEntity<Root> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Root.class
        );
        ResponseEntity<String> response2 = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response.getStatusCode() == HttpStatus.OK ?
                response.getBody() :
                objectMapper.readValue(response2.getBody(), Root.class);
    }



//    TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ==    --> OTP validation


//    public ResponseEntity<Customer> verifyOTP( String validOTP)
//    {
//
//
//        return ResponseEntity<customer>;
//    }

}
