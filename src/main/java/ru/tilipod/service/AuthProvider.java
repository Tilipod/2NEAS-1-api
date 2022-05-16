package ru.tilipod.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.tilipod.controller.dto.User;
import ru.tilipod.feign.scheduler.SchedulerApi;

@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final SchedulerApi schedulerApi;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user;
        try {
            user = schedulerApi.findUserByUsernameUsingGET(username)
                    .getBody();
        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Username not found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }

        return new UsernamePasswordAuthenticationToken(user, password, user.getRoles());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
