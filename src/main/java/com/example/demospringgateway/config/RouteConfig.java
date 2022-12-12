package com.example.demospringgateway.config;

import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

@Configuration
public class RouteConfig {
   /* @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder, RouteDefinitionLocator routeLocator) {
        final var routes = routeLocator.getRouteDefinitions().collectList().block();

        routes.stream().forEach(route -> {
            final var name = route.getId();
            routeLocatorBuilder.routes()
                    .route(name, r -> {
                        return r.alwaysTrue()
                                .filters(f -> {
                                    f.addRequestHeader("X-IBM-Client-Id", "devKey");
                                    f.addRequestHeader("X-IBM-Client-Secret", "Secret");
                                    return f;
                                })
                                .uri(route.getUri());
                    })
                    .build();
        });
        return routeLocatorBuilder.routes().build();
    }*/
}
