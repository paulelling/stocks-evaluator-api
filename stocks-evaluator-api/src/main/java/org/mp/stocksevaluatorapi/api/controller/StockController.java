package org.mp.stocksevaluatorapi.api.controller;

import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public Stock getStock(@RequestParam String ticker) {
        Optional stock = stockService.getStock(ticker);
        if (stock.isPresent()) {
            return (Stock) stock.get();
        }
        return null;
    }
}
