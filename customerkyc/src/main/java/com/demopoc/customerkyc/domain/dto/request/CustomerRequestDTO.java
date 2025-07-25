package com.demopoc.customerkyc.domain.dto.request;

import com.demopoc.customerkyc.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequestDTO {
    private String name;
    private Date dateOfBirth;
    private Gender gender;
    private String aadhaarNo;
    private String address;
}
