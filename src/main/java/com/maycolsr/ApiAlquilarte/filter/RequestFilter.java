package com.maycolsr.ApiAlquilarte.filter;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;

//Implementa la clase Filter desde javax.servlet
//@Component //identifica que la clase es un componente
public class RequestFilter implements Filter {

    //MacProvider es un metodo de la dependencia JsonWebToken
    public static final Key KEY = MacProvider.generateKey();

    //Implementamos el metodo doFilter
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        //Permitimos que el sistema haga cast
        HttpServletResponse respuesta = (HttpServletResponse) response;
        HttpServletRequest peticion = (HttpServletRequest) request;

        //puede acceder cualquier servidor "*" url
        respuesta.addHeader("Access-Control-Allow-Origin", "*");
        //puede realizar procesos cualquier metodo "*"
        //respuesta.addHeader("Access-Control-Allow-Methods", "*");
        //permite todos los encabezados
        //respuesta.addHeader("Access-Control-Allow-Headers", "*");


        //tokens
        String url = peticion.getRequestURI();
        //Validacion de recursos
        if (url.contains("/usuarios/login") || url.contains("/usuarios/registrar")) {
            //si la url contiene ese String, permite el acceso
            chain.doFilter(request, response);
        }
        else {
            String token = peticion.getHeader("Authorization");
            if (token==null || token.trim().equals("")) {
                response.setContentType("application/json");
                String salida = "{\"AUTORIZACION\": \"NO_TOKEN\"}";
                response.getWriter().write(salida);
            }
            else {
                token = token.substring(7, token.length());
                try {
                    Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
                    chain.doFilter(request, response);
                }
                catch (MalformedJwtException e){
                    response.setContentType("application/json");
                    String salida = "{\"AUTORIZACION\": \"TOKEN_MALFORMED\"}";
                    response.getWriter().write(salida);
                }
                catch (SignatureException e) {
                    response.setContentType("application/json");
                    String salida = "{\"AUTORIZACION\": \"TOKEN_SIGNATURE\"}";
                    response.getWriter().write(salida);
                }
                catch (ExpiredJwtException e) {
                    response.setContentType("application/json");
                    String salida = "{\"AUTORIZACION\": \"TOKEN_EXPIRED\"}";
                    response.getWriter().write(salida);
                }
                catch (Exception e) {
                    response.setContentType("application/json");
                    String salida = "{\"AUTORIZACION\": \"ERROR\"}";
                    response.getWriter().write(salida);
                }
            }
        }
    }
}

