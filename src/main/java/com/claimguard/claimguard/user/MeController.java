package com.claimguard.claimguard.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meController")
public class MeController
{
    @GetMapping("/me")
    public Map<String,Object> me(Authentication authentication){
        List<String> authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return Map.of("username",authentication.getName(),
                "authorities",authorities,
                "authenticated",authentication.isAuthenticated());
    }

}
