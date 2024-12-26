package com.nttdata.nttbank.infra.gateways.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class MockAPIService {

    private static final String BASE_URL = "https://6751ef72d1983b9597b4debb.mockapi.io/api";

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final CurrencyConverterService currencyConverterService;

    public List<LinkedHashMap<String, String>> getSaldos() {
        try {
            String url = BASE_URL + "/saldos";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<LinkedHashMap<String, String>> saldos = objectMapper.readValue(response.body(), List.class);

            return saldos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar saldo do usuário", e);
        }
    }

    public List<LinkedHashMap<String, String>> getTransacoes() {
        try {
            String url = BASE_URL + "/transacoes";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<LinkedHashMap<String, String>> transacoes = objectMapper.readValue(response.body(), List.class);

            return transacoes;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar saldo do usuário", e);
        }
    }
}