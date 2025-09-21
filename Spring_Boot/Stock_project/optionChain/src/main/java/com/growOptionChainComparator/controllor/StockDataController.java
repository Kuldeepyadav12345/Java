package com.growOptionChainComparator.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growOptionChainComparator.dto.HighStrikePriceDTO;
import com.growOptionChainComparator.model.BankNiftyCompanies;
import com.growOptionChainComparator.service.GetHighestVolumeEveryFiveSecond;
import com.growOptionChainComparator.service.LivePriceService;
import com.growOptionChainComparator.service.StockDataService;

@RestController
@RequestMapping("/api")
public class StockDataController {
    
    @Autowired
    private StockDataService stockDataService;

    @GetMapping("/highestStrikePrice")
    public List<HighStrikePriceDTO> getHighestStrikePrices() {
        return GetHighestVolumeEveryFiveSecond.getLatestHighStrikePrices();
    }
    
    @GetMapping("/bankNiftyAllCompaniesData")
    public BankNiftyCompanies AllBankNiftyCompanies() {
        return LivePriceService.returnAllBankNiftyCompanies();
    }
}
