package com.example.repository;

import com.example.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StockRepository extends JpaRepository<Stock, Integer> {

    @Query("SELECT w FROM Stock w WHERE w.nameW = :nameW")
    Stock findByNameW(String nameW);

}


