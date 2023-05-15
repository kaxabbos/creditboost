package com.creditboost.controller.main;

import com.creditboost.model.enums.AppsStatus;
import com.creditboost.model.enums.Goals;
import com.creditboost.model.enums.Role;
import org.springframework.ui.Model;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAll());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesCredits(Model model) {
        AddAttributes(model);
        model.addAttribute("credits", creditsRepo.findAll());
        model.addAttribute("goals", Goals.values());
    }

    protected void AddAttributesCredit(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("credit", creditsRepo.getReferenceById(id));
    }

    protected void AddAttributesApps(Model model) {
        AddAttributes(model);
        model.addAttribute("apps", appsRepo.findAllByStatus(AppsStatus.WAITING));
    }

    protected void AddAttributesCreditsMy(Model model) {
        AddAttributes(model);
        model.addAttribute("apps", getUser().getAppsList());
    }

    protected void AddAttributesClients(Model model) {
        AddAttributes(model);
        model.addAttribute("clients", usersRepo.findAll());
    }

    protected void AddAttributesCreditsSearch(Model model, Goals goal) {
        AddAttributes(model);
        model.addAttribute("credits", creditsRepo.findAllByGoal(goal));
        model.addAttribute("goals", Goals.values());
        model.addAttribute("selectedG", goal);
    }

    protected void AddAttributesCreditAdd(Model model) {
        AddAttributes(model);
        model.addAttribute("goals", Goals.values());
    }
}
