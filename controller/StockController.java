package com.example.controller;

import com.example.dto.Head;
import com.example.dto.StockDto;
import com.example.dto.StockHistory;
import com.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/*
This layer is responsible for receiving requests and sending answers to the user.
 */

@Controller
public class StockController {

    @Autowired
    private StockService service;

    @GetMapping("/homeStock")
    public String getHomeStock(){
        return "homeStock";
    }

    @GetMapping("/getStock")
    public String getStockDetails(@RequestParam String stockName, Model model) throws Exception {
        StockDto stockDto = service.getStockInfo(stockName);
        List<StockDto> stockList = new ArrayList<>();
        stockList.add(stockDto);
        model.addAttribute("stockList", stockList);
        return "homeStock";
    }

    @GetMapping("/getHistory/{stockName}")
    public String getHistory(@RequestParam String stockName, Model model) throws Exception {
        List<Head> headers = getHeaders();
        List<StockHistory> histories = service.getHistory(stockName, 0, null);
        model.addAttribute("msg", "Stock History up to today :");
        model.addAttribute("headers", headers);
        model.addAttribute("histories", histories);
        return "homeStock";
    }

    @GetMapping("/exportStockHistory")
    public String exportHistory(@RequestParam("stockName") String stockName, @RequestParam("year") int year,
                                @RequestParam("field") String searchType, Model model) throws Exception {
        List<Head> headers = getHeaders();
        List<StockHistory> histories = service.getHistory(stockName, year, searchType);
        model.addAttribute("msg",
                year + " Year " + searchType.toLowerCase() + " Stock History of " + stockName + " : ");
        model.addAttribute("headers", headers);
        model.addAttribute("histories", histories);
        return "homeStock";
    }

    private List<Head> getHeaders() {
        List<Head> headers = new ArrayList<>();
        headers.add(new Head("Symbol", "Date", "High(price)", "Low(price)", "closed(price)"));
        return headers;
    }


}
