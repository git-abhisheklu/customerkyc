package com.demopoc.customerkyc.domain.dto.response;

import com.demopoc.customerkyc.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {
    private String Name;
    private Date DateOfBirth;
    private Gender gender;
    private String Address;
}
