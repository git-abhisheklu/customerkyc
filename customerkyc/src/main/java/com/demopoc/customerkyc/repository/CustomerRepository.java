package com.demopoc.customerkyc.repository;

import com.demopoc.customerkyc.entity.Customer;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
