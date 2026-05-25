package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    @@ -24,4 +27,15 @@
    public String introduce(@RequestParam String name) {
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> result = new HashMap<>();

        result.put("age", 25);
        result.put("name", "박준용");

        return result;
    }
}

