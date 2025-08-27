package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.service.StockDataService;
import com.data.dto.HighStrikePriceDTO;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockDataController {
    
    @Autowired
    private StockDataService stockDataService;

    @GetMapping("/highestStrikePrice")
    public List<HighStrikePriceDTO> getHighestStrikePrices() {
        return stockDataService.getLatestHighStrikePrices();
    }
}
