package cn.nihility.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = {"cn.nihility.controller"})
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger log = LoggerFactory.getLogger(MyResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        log.info("MyResponseBodyAdvice -> supports MethodParameter [{}] converterType [{}]", returnType.getMember(), converterType.getName());
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("MyResponseBodyAdvice -> beforeBodyWrite body [{}] MethodParameter [{}] MediaType [{}]", body, returnType.getMember(), selectedContentType.getType());

        Map<String, Object> unify = new HashMap<>();
        unify.put("apiVersion", "1.0.1");
        unify.put("data", body);
        unify.put("message", "统一请求");

        return unify;
    }
}
