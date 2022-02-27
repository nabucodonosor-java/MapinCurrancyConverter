package com.mapin.currancyconvert.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mapin.currancyconvert.dto.QuoteASKByDateDTO;
import com.mapin.currancyconvert.dto.QuoteBIDByDateDTO;
import com.mapin.currancyconvert.dto.QuoteDTO;
import com.mapin.currancyconvert.model.Quote;
import com.mapin.currancyconvert.model.comparators.QuoteASKPeriodComparator;
import com.mapin.currancyconvert.model.comparators.QuoteBIDPeriodComparator;
import com.mapin.currancyconvert.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Transactional(readOnly = true)
    public Page<QuoteDTO> findAllWithFilters(String minDate, String maxDate, String currancy, Pageable pageable) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        Page<Quote> page = quoteRepository.findAllWithFilters(min, max, currancy, pageable);
        return QuoteDTO.converter(page);
    }

    @Transactional(readOnly = true)
    public List<QuoteBIDByDateDTO> dashboardBIDByDate(String minDate, String maxDate, String currancy) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<QuoteBIDByDateDTO> list = quoteRepository.dashboardBIDByDate(min, max, currancy);
        Collections.sort(list, new QuoteBIDPeriodComparator());
        return list;
    }

    @Transactional(readOnly = true)
    public List<QuoteASKByDateDTO> dashboardASKByDate(String minDate, String maxDate, String currancy) {
        LocalDate min = "".equals(minDate) ? null : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? null : LocalDate.parse(maxDate);
        List<QuoteASKByDateDTO> list = quoteRepository.dashboardASKByDate(min, max, currancy);
        Collections.sort(list, new QuoteASKPeriodComparator());
        return list;
    }

    @Transactional(readOnly = true)
    public QuoteDTO currentUSDQuote() throws IOException {
        LocalDate dataAtualUSD = LocalDate.now();
        String urlUSD = "USD-BRL";
        String urlConnUSD = "USDBRL";

        // Cotação Dólar
        JsonObject reqUSD = connectToUrlAndReturnJsonObject(urlUSD, urlConnUSD);

        String codeUSD = String.valueOf(reqUSD.get("code"));
        String highUSD = String.valueOf(reqUSD.get("high").getAsDouble());
        String lowUSD = String.valueOf(reqUSD.get("low").getAsDouble());
        String bidUSD = String.valueOf(reqUSD.get("bid").getAsDouble());
        String askUSD = String.valueOf(reqUSD.get("ask").getAsDouble());

        String[] codeSPlit = codeUSD.split("");
        String tempUSD = codeSPlit[1]+codeSPlit[2]+codeSPlit[3];

        QuoteDTO dollarQuote = new QuoteDTO();
        dollarQuote.setCode(tempUSD);
        dollarQuote.setHigh(Double.parseDouble(highUSD));
        dollarQuote.setLow(Double.parseDouble(lowUSD));
        dollarQuote.setBid(Double.parseDouble(bidUSD));
        dollarQuote.setAsk(Double.parseDouble(askUSD));
        dollarQuote.setDate(dataAtualUSD);

        return dollarQuote;
    }

    @Transactional(readOnly = true)
    public QuoteDTO currentEURQuote() throws IOException {
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

        QuoteDTO quoteEUR = new QuoteDTO();
        quoteEUR.setCode(tempEUR);
        quoteEUR.setHigh(Double.parseDouble(highEUR));
        quoteEUR.setLow(Double.parseDouble(lowEUR));
        quoteEUR.setBid(Double.parseDouble(bidEUR));
        quoteEUR.setAsk(Double.parseDouble(askEUR));
        quoteEUR.setDate(dataAtualEUR);

        return quoteEUR;
    }

    @Transactional(readOnly = true)
    public QuoteDTO currentBTCQuote() throws IOException {
        String urlBIT = "BTC-BRL";
        String urlConnBIT = "BTCBRL";

        JsonObject reqBTC = connectToUrlAndReturnJsonObject(urlBIT, urlConnBIT);

        String codeBTC = String.valueOf(reqBTC.get("code"));
        String highBTC = String.valueOf(reqBTC.get("high").getAsDouble());
        String lowBTC = String.valueOf(reqBTC.get("low").getAsDouble());
        String bidBTC = String.valueOf(reqBTC.get("bid").getAsDouble());
        String askBTC = String.valueOf(reqBTC.get("ask").getAsDouble());

        LocalDate dataAtualBTC = LocalDate.now();

        String[] codeBITSPlit = codeBTC.split("");
        String tempBIT = codeBITSPlit[1]+codeBITSPlit[2]+codeBITSPlit[3];

        QuoteDTO quoteBTC = new QuoteDTO();
        quoteBTC.setCode(tempBIT);
        quoteBTC.setHigh(Double.parseDouble(highBTC));
        quoteBTC.setLow(Double.parseDouble(lowBTC));
        quoteBTC.setBid(Double.parseDouble(bidBTC));
        quoteBTC.setAsk(Double.parseDouble(askBTC));
        quoteBTC.setDate(dataAtualBTC);

        return quoteBTC;
    }

    private JsonObject connectToUrlAndReturnJsonObject(String currancy, String urlConn) throws MalformedURLException, IOException {
        URL url = new URL("https://economia.awesomeapi.com.br/last/"+currancy);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream)request.getContent()));
        JsonObject rootObj = root.getAsJsonObject();
        JsonObject quote = rootObj.get(urlConn).getAsJsonObject();
        return quote;
    }


}
