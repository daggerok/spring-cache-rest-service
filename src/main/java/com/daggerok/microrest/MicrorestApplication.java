package com.daggerok.microrest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching // 3
@SpringBootApplication(exclude = {
        MultipartAutoConfiguration.class,
        WebSocketAutoConfiguration.class
})
public class MicrorestApplication {

    @Bean // 3
    public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
        return (ConcurrentMapCacheManager cacheManager) -> cacheManager.setCacheNames(Arrays.asList("books"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MicrorestApplication.class, args);
    }
}
