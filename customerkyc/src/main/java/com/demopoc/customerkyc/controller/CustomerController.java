package com.demopoc.customerkyc.controller;

import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/verify")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/generate-otp")
    public ResponseEntity<?> generateOTP(@RequestParam String aadhaarNo){
        ResponseEntity<?> customerResponseDTO= customerService.generateOTP(aadhaarNo);
        return ResponseEntity.ok(customerResponseDTO);
    }
}
