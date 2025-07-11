package com.demopoc.customerkyc.domain.dto.response;

import com.demopoc.customerkyc.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDTO {

        private String client_id;
        private boolean otp_sent;
        private boolean if_number;
        private boolean valid_aadhaar;
}