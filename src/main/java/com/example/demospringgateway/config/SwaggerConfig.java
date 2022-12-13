package com.example.demospringgateway.config;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SwaggerConfig {

    @Autowired
    RouteDefinitionLocator locator;

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(){
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream().filter(routeDefinition -> !"openapi".equals(routeDefinition.getId())).forEach(routeDefinition -> {
            String name = routeDefinition.getId();
            GroupedOpenApi api = GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
            groups.add(api);
        });
        return groups;
    }
}
