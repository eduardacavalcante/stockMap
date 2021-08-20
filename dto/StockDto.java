package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockDto {
    private String name;
    private BigDecimal price;
    private BigDecimal change;
    private String currency;
    private BigDecimal bid;

    public StockDto(String name, BigDecimal price, BigDecimal change, String currency, BigDecimal bid, BigDecimal changeFromYearHighInPercent, String toUpperCase) {
        this.name = name;
        this.price = price;
        this.change = change;
        this.currency = currency;
        this.bid = bid;
    }


}
