package com.example.newproviderfacingapp.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class AuthApi {
    public void getAuthorize(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests((authorize) -> {
            try {
                authorize.antMatchers("/login").hasAuthority("User").
                        and().csrf().configure(httpSecurity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void getAuthToken(){
        String response="https://fhir.epic.com/interconnect-fhir-oauth/oauth2/authorize?scope=launch&response_type=code&redirect_uri=https://06a3-150-107-190-51.ngrok-free.app&client_id=8629ecf9-3642-4ed1-a673-49951da5e557&state=state";
//        String token=response.get
    }
}
