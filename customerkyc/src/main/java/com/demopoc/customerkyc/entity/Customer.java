package com.demopoc.customerkyc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private Long id;
    private String Name;
    private Date DateOfBirth;
    private

}
