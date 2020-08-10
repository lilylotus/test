package cn.nihility.controller;

import cn.nihility.entity.QueryParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/param")
    public Map<String, Object> requestParam(QueryParams params) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "Success");
        result.put("data", params);

        System.out.println(params);

        return result;
    }

}
