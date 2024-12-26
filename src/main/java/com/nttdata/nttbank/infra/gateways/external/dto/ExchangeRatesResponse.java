package com.nttdata.nttbank.infra.gateways.external.dto;

import java.util.Map;

public class ExchangeRatesResponse {
    private String base;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
