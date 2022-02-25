package com.mapin.currancyconvert.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mapin.currancyconvert.model.Quote;
import com.mapin.currancyconvert.repositories.QuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

@Component
@EnableScheduling
public class ScheduledConfigs {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledConfigs.class);

    @Autowired
    private QuoteRepository quoteRepository;

    @Scheduled(fixedDelay = HORA)
    public void verificaPorSegundo() throws IOException {

        String urlUSD = "USD-BRL";
        String urlConnUSD = "USDBRL";

        // Cotação Dólar
        JsonObject reqUSD = connectToUrlAndReturnJsonObject(urlUSD, urlConnUSD);

        String codeUSD = String.valueOf(reqUSD.get("code"));
        String highUSD = String.valueOf(reqUSD.get("high").getAsDouble());
        String lowUSD = String.valueOf(reqUSD.get("low").getAsDouble());
        String bidUSD = String.valueOf(reqUSD.get("bid").getAsDouble());
        String askUSD = String.valueOf(reqUSD.get("ask").getAsDouble());

        LocalDate dataAtualUSD = LocalDate.now();

        String[] codeSPlit = codeUSD.split("");
        String tempUSD = codeSPlit[1]+codeSPlit[2]+codeSPlit[3];

        Quote dollarQuote = new Quote();
        dollarQuote.setCode(tempUSD);
        dollarQuote.setHigh(Double.parseDouble(highUSD));
        dollarQuote.setLow(Double.parseDouble(lowUSD));
        dollarQuote.setBid(Double.parseDouble(bidUSD));
        dollarQuote.setAsk(Double.parseDouble(askUSD));
        dollarQuote.setDate(dataAtualUSD);
        quoteRepository.save(dollarQuote);

//        // Cotação Euro

        String urlEUR = "EUR-BRL";
        String urlConnEUR = "EURBRL";

        JsonObject reqEUR = connectToUrlAndReturnJsonObject(urlEUR, urlConnEUR);

        String codeEUR = String.valueOf(reqEUR.get("code"));
        String highEUR = String.valueOf(reqEUR.get("high").getAsDouble());
        String lowEUR = String.valueOf(reqEUR.get("low").getAsDouble());
        String bidEUR = String.valueOf(reqEUR.get("bid").getAsDouble());
        String askEUR = String.valueOf(reqEUR.get("ask").getAsDouble());

        LocalDate dataAtualEUR = LocalDate.now();

        String[] codeEURSPlit = codeEUR.split("");
        String tempEUR = codeEURSPlit[1]+codeEURSPlit[2]+codeEURSPlit[3];

        Quote quoteEUR = new Quote();
        quoteEUR.setCode(tempEUR);
        quoteEUR.setHigh(Double.parseDouble(highEUR));
        quoteEUR.setLow(Double.parseDouble(lowEUR));
        quoteEUR.setBid(Double.parseDouble(bidEUR));
        quoteEUR.setAsk(Double.parseDouble(askEUR));
        quoteEUR.setDate(dataAtualEUR);
        quoteRepository.save(quoteEUR);

//        // Cotação Bitcoin
//        JsonObject reqBTC = connectToUrlAndReturnJsonObjectBTC();
//
//        String codeBTC = String.valueOf(reqBTC.get("code"));
//        String nameBTC = String.valueOf(reqBTC.get("name"));
//        String highBTC = String.valueOf(reqBTC.get("high").getAsDouble());
//        String lowBTC = String.valueOf(reqBTC.get("low").getAsDouble());
//        String bidBTC = String.valueOf(reqBTC.get("bid").getAsDouble());
//        String askBTC = String.valueOf(reqBTC.get("ask").getAsDouble());
//
//        LocalDate dataAtualBTC = LocalDate.now();
//
//        Quote quoteBTC = new Quote();
//        quoteBTC.setCode(codeBTC);
//        quoteBTC.setName(nameBTC);
//        quoteBTC.setHigh(Double.parseDouble(highBTC));
//        quoteBTC.setLow(Double.parseDouble(lowBTC));
//        quoteBTC.setBid(Double.parseDouble(bidBTC));
//        quoteBTC.setAsk(Double.parseDouble(askBTC));
//        quoteBTC.setDate(dataAtualBTC);
//        quoteRepository.save(quoteBTC);

    }

    private JsonObject connectToUrlAndReturnJsonObject(String currancy, String urlConn) throws MalformedURLException, IOException{
        URL url = new URL("https://economia.awesomeapi.com.br/last/"+currancy);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream)request.getContent()));
        JsonObject rootObj = root.getAsJsonObject();
        JsonObject quote = rootObj.get(urlConn).getAsJsonObject();
        return quote;
    }
}
