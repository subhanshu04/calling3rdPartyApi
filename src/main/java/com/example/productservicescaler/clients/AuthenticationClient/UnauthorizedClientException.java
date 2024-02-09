package com.example.productservicescaler.clients.AuthenticationClient;

public class UnauthorizedClientException extends Exception{
    UnauthorizedClientException(String msg){
        super(msg);
    }
}
