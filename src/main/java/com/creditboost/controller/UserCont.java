package com.creditboost.controller;

import com.creditboost.controller.main.Attributes;
import com.creditboost.model.UserDescriptions;
import com.creditboost.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserCont extends Attributes {
    @GetMapping
    public String user(Model model) {
        AddAttributes(model);
        return "user";
    }

    @PostMapping("/edit")
    public String userEdit(@RequestParam String fio, @RequestParam String tel, @RequestParam String citizenship, @RequestParam String passport) {
        UserDescriptions userDescription = getUser().getDescription();
        userDescription.setFio(fio);
        userDescription.setTel(tel);
        userDescription.setCitizenship(citizenship);
        userDescription.setPassport(passport);
        userDescriptionsRepo.save(userDescription);
        return "redirect:/user";
    }
}
