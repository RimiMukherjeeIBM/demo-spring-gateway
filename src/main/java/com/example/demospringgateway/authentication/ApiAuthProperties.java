package com.example.demospringgateway.authentication;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "apiauth")
@Getter
@Setter
@Data
public class ApiAuthProperties {
    private String apiKeySecrets;
}
