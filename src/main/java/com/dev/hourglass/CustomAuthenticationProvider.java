package com.dev.hourglass;

import com.dev.hourglass.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    // Queries the API to gather all stored employee credentials
    // Then checks login input to determine if credentials are valid
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        final String username = auth.getName();
        final String password = auth.
                getCredentials()
                .toString();

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = "http://localhost:4000/employee/validate";

        ResponseEntity<Employee[]> response =
                restTemplate.getForEntity(
                        apiUrl,
                        Employee[].class);
        List<Employee> employees = Arrays.asList(response.getBody());

        for (int i = 0; i < employees.size(); i++) {

            if(employees.get(i).getUsername().equals(username) && employees.get(i).getPassword().equals(password)){
                return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
            }

        }
        throw new BadCredentialsException("External system authentication failed");

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}