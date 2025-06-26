package com.demopoc.customerkyc.controller;

import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/verify")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/generate-otp")
    public ResponseEntity<CustomerResponseDTO> generateOTP(@RequestBody String aadhaarNo){
        CustomerResponseDTO customerResponseDTO= customerService.generateOTP(aadhaarNo);
        return ResponseEntity.ok(customerResponseDTO);
    }
}
