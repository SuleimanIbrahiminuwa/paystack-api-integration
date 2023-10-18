package com.example.PaystackAPIIntegration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@TestConfiguration
@PropertySources({
        @PropertySource("classpath:application.properties"),
})
public class TestConfig {

    @Bean
    public String payStackApiKey() {
        return "sk_test_61377fe89e5310b64e235c9b6168fda62ae3db6c";
    }
}
