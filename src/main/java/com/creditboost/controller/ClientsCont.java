package com.creditboost.controller;

import com.creditboost.controller.main.Attributes;
import com.creditboost.model.Apps;
import com.creditboost.model.enums.AppsStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientsCont extends Attributes {

    @GetMapping
    public String clients(Model model) {
        AddAttributesClients(model);
        return "clients";
    }
}
