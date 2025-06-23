package com.demopoc.customerkyc.service;

import com.demopoc.customerkyc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String sendOTP()
    {

        return "OTP sent";
    }

    public String verifyOTP()
    {
        return "OTP has been verified";
    }

}
