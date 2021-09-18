package com.upgrad.patterns.Authentication;

import com.upgrad.patterns.Middleware.AuthenticationProcessor;
import com.upgrad.patterns.Middleware.BasicAuthProcessor;
import com.upgrad.patterns.Middleware.JwtAuthProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class Authenticator {
    private static Logger logger = LoggerFactory.getLogger(Authenticator.class);
	
//create a public static method GetAuthProcessor of the return type AuthenticationProcessor
	// create an object of type JwtAuthProcessor
	// Chain Authentication processors, first JWT processor is to be used first and then basic auth processor
	// return the object
    public static void GetAuthProcessor (HttpServletRequest request) {
        //this needs to be finished
        logger.info("Auth type: {}", request.getAuthType());
    }
	

    public static AuthenticationProvider GetAuthProvider(HttpServletRequest request)
    {
        if(request.getHeader("Authorization") != null)
            return new JwtAuthProvider(request.getHeader("Authorization"));
        return new BasicAuthProvider(request.getHeader("Username"), request.getHeader("Password"));
    }
}
