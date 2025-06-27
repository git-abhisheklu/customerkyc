package com.demopoc.customerkyc.controller;

import com.demopoc.customerkyc.domain.dto.request.OtpRequestDTO;
import com.demopoc.customerkyc.domain.dto.response.CustomerResponseDTO;
import com.demopoc.customerkyc.domain.dto.response.Root;
import com.demopoc.customerkyc.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/verify")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/generate-otp")
    public ResponseEntity<Root> generateOTP(@RequestBody OtpRequestDTO request){
        Root customerResponseDTO= null;
        try {
            customerResponseDTO = customerService.generateOTP(request.getId_number());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(customerResponseDTO);
    }
}
