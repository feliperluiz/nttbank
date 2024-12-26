package com.nttdata.nttbank.infra.gateways.external;

import com.nttdata.nttbank.infra.gateways.external.dto.ExchangeRatesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyConverterService {

    @Value("${exchange-rates.api.url}")
    private String apiUrl;

    public BigDecimal convertToCurrency(String targetCurrency, BigDecimal amountInBRL) {
        Double exchangeRate = this.retornaTaxaDeCambio(targetCurrency);

        return amountInBRL.multiply(new BigDecimal(exchangeRate)).setScale(2, RoundingMode.HALF_UP);
    }

    public Double retornaTaxaDeCambio(String targetCurrency) {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("%s/%s", apiUrl, "BRL");
        ExchangeRatesResponse response = restTemplate.getForObject(url, ExchangeRatesResponse.class);

        if (response == null || response.getRates() == null) {
            throw new IllegalStateException("Não foi possível obter taxas de câmbio.");
        }

        Double exchangeRate = response.getRates().get(targetCurrency.toUpperCase());
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Moeda de destino inválida: " + targetCurrency);
        }
        return exchangeRate;
    }
}
