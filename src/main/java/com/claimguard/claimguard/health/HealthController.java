package com.claimguard.claimguard.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/healthController")
public class HealthController
{
    @GetMapping("/health")
    public Map<String,Object> health()
    {
        System.out.println("Inside Health Controller --> health()");
        return Map.of(
                "status", "UP",
                "service", "claimguard-backend",
                "timestamp", LocalDateTime.now().toString()
        );    }

}
