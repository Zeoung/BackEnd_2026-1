package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    @@ -17,4 +18,10 @@
    public String hello2() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/introduce")
    public String introduce(@RequestParam String name) {
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }
}


