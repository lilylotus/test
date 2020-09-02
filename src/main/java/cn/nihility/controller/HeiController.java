package cn.nihility.controller;

import cn.nihility.controller.result.ResponseResultBody;
import cn.nihility.controller.result.ResultResponse;
import cn.nihility.entity.QueryParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hei")
public class HeiController {

    private static final Map<String, Object> RESULT_DATA;

    static {
        RESULT_DATA = new HashMap<>();
        RESULT_DATA.put("status", 200);
        RESULT_DATA.put("message", "自定义 Hei 信息");
        RESULT_DATA.put("name", "anonymous");
        try {
            RESULT_DATA.put("remote", Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

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

    @RequestMapping("/data")
    public Map<String, Object> data() {
        return RESULT_DATA;
    }

    @RequestMapping("/result")
    @ResponseBody
    public ResultResponse<Map<String, Object>> result() {
        return ResultResponse.success(RESULT_DATA);
    }

    @RequestMapping("/resultBody")
    @ResponseResultBody
    public Map<String, Object> resultBody() {
        return RESULT_DATA;
    }

}
