package com.demopoc.customerkyc.entity;

import com.demopoc.customerkyc.domain.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private Long id;
    private String name;
    private Date dateOfBirth;
    private Gender gender;
    private String aadhaarNo;
    private String address;
}
