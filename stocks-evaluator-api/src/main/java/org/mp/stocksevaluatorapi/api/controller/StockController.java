package org.mp.stocksevaluatorapi.api.controller;

import org.mp.stocksevaluatorapi.api.model.Stock;
import org.mp.stocksevaluatorapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/stock")
    public Stock getStock(@RequestParam String ticker) throws IOException, ParserConfigurationException, SAXException {
        Stock stock = stockService.getStock(ticker);
        return stock;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/stock")
//    public Stock getStock(@RequestParam String ticker) throws ParserConfigurationException, IOException, SAXException, SQLException {
//        return stockService.getStock(ticker);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/stocks")
    public List<Stock> getStocks() throws ParserConfigurationException, IOException, SAXException, SQLException {
        return stockService.getStockList();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/testapi")
//    public String callApi() throws IOException {
//        AlphaVantage alphaVantage = new AlphaVantage();
//        return alphaVantage.getStockData("IBM");
//    }


}
