package com.demopoc.customerkyc.domain.dto.response;

import lombok.*;
import lombok.Data;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    public int statuscode;
    public boolean status;
    public String message;
    public CustomerResponseDTO data;
}