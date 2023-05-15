package com.creditboost.controller;

import com.creditboost.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCont extends Attributes {
    @GetMapping
    public String index1() {
        return "redirect:/credits";
    }

    public String index2() {
        return "redirect:/credits";
    }

    @GetMapping("/index")
    public String index3() {
        return "redirect:/credits";
    }
}
