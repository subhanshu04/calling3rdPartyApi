package com.example.productservicescaler.security.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    //To extract the roles out of JWT token
    private static Collection<? extends GrantedAuthority> extractResourceRoles(final Jwt jwt){
        List<String> roles=jwt.getClaim("roles");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(String role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthorities;
    }
    //JwtGrantedAuthoritiesConverter is a class used in Spring Security for converting JWT (JSON Web Token) claims into a collection of GrantedAuthority objects.
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    @Override
    public AbstractAuthenticationToken convert(final Jwt source) {

        Collection<GrantedAuthority> grantedAuthorities = Stream.concat(
                //Convert the claims in Granted authority objects
                jwtGrantedAuthoritiesConverter.convert(source).stream(),
                //Get additional roles from jwt
                extractResourceRoles(source).stream())
                //Concat and create a list of all the granted authorities.
                .collect(Collectors.toSet());

        //Add all the granted authorities in the JWT
        return new JwtAuthenticationToken(source,grantedAuthorities);
    }
}
