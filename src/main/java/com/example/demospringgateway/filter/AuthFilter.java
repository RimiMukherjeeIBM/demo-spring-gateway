package com.example.demospringgateway.filter;

import com.example.demospringgateway.authentication.ApiAuthProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class AuthFilter implements GlobalFilter {

    @Autowired
    private ApiAuthProperties apiAuthProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final var objectMapper = new ObjectMapper();
        try {
            final var apiKeySecrets = objectMapper.readValue(apiAuthProperties.getApiKeySecrets(), new TypeReference<Map<String, Map<String, String>>>() {
            });
            final var route = (Route) exchange.getAttributes().get(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
            final var apiKeySecretsForRoute = apiKeySecrets.computeIfPresent(route.getId(), (key, value) -> apiKeySecrets.get(key));
            final var key = apiKeySecretsForRoute.keySet().stream().findFirst().get();
            return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().header("X-IBM-Client-Id", key).header("X-IBM-Client-Secret", apiKeySecretsForRoute.get(key)).build()).build());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

   /* @Override
    public int getOrder() {
        return 0;
    }*/
}
