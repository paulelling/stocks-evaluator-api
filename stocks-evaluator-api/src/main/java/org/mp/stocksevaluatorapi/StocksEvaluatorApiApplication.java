package org.mp.stocksevaluatorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StocksEvaluatorApiApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(StocksEvaluatorApiApplication.class, args);

//        AlphaVantage alphaVantage = new AlphaVantage();
//        BalanceSheet balanceSheet = alphaVantage.getBalanceSheet("IBM");


//        ApiCall json = new ApiCall();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject = json.readJsonFromUrl("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=demo");
//        //System.out.println(jsonObject);
//        //System.out.println(jsonObject.get("Global Quote"));
//
//        Object jsonObject1 = new JSONObject();
//        jsonObject1 = jsonObject.get("Global Quote");
//
//        JSONObject jsonObject2 = new JSONObject();
//        jsonObject2 = (JSONObject) jsonObject1;
//
//        System.out.println(jsonObject2.get("05. price"));



    }

}
