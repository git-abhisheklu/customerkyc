package com.demopoc.customerkyc.service;

import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.entity.Customer;
import com.demopoc.customerkyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> generateOTP(String aadhaarNo)
    {
        String url="https://uat.paysprint.in/sprintverify-uat/api/v1/verification/aadhaar_verifyotp";
        Map<String,String> requestBody=new HashMap<String,String>();
        requestBody.put("aadhaar_no",aadhaarNo);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Bearer TVRJek5EVTJOelUwTnpKRFQxSlFNREF3TURFPQ==");
        HttpEntity httpEntity=new HttpEntity(requestBody,httpHeaders);
        var customer= restTemplate.exchange(url, HttpMethod.POST,httpEntity,Customer.class);
        return customer;
    }

//    public ResponseEntity<Customer> verifyOTP( String validOTP)
//    {
//
//
//        return ResponseEntity<customer>;
//    }

}
