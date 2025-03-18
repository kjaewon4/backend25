package com.bu.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/test")
    public String test(Model m) {


        m.addAttribute("username", "나");
        return "temp";
    }

    @GetMapping("/test2")
    public String test2(Model m) {
        m.addAttribute("message", "배고파");
        m.addAttribute("currentDate", new java.util.Date());

        return "temp2";
    }

}
