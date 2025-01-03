package com.nttdata.nttbank.infra.controller;

import com.nttdata.nttbank.infra.gateways.external.CurrencyConverterService;
import com.nttdata.nttbank.infra.gateways.external.MockAPIService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/api")
public class MockAPIController {

    private final MockAPIService mockAPIService;

    private final CurrencyConverterService currencyConverterService;

    @GetMapping("/saldos")
    public ResponseEntity<List<LinkedHashMap<String,String>>> getSaldos() {
        List<LinkedHashMap<String, String>> saldos = mockAPIService.getSaldos();
        if (saldos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saldos);
    }

    @GetMapping("/transacoes")
    public ResponseEntity<List<LinkedHashMap<String, String>>> getTransacoes() {
        List<LinkedHashMap<String, String>> transacoes = mockAPIService.getTransacoes();
        transacoes.get(0).put("Câmbio USD", String.valueOf(currencyConverterService.retornaTaxaDeCambio("USD")));
        transacoes.get(0).put("Câmbio EUR", String.valueOf(currencyConverterService.retornaTaxaDeCambio("EUR")));
        if (transacoes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacoes);
    }


}
