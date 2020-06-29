package cn.nihility.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hei")
public class HeiController {

    @RequestMapping("/hello")
    public Map<String, Object> hello(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "Success");
        result.put("remote", request.getRemoteAddr());
        return result;
    }

}
