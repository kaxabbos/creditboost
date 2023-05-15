package com.creditboost.controller;

import com.creditboost.controller.main.Attributes;
import com.creditboost.model.Apps;
import com.creditboost.model.Credits;
import com.creditboost.model.enums.AppsStatus;
import com.creditboost.model.enums.Goals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/credits")
public class CreditsCont extends Attributes {

    @GetMapping
    public String credits(Model model) {
        AddAttributesCredits(model);
        return "credits";
    }

    @GetMapping("/{id}")
    public String credit(Model model, @PathVariable Long id) {
        AddAttributesCredit(model, id);
        return "credit";
    }

    @GetMapping("/my")
    public String creditsMy(Model model) {
        AddAttributesCreditsMy(model);
        return "creditsMy";
    }

    @GetMapping("/my/repaid/{id}")
    public String creditRepaid(@PathVariable Long id) {
        Apps apps = appsRepo.getReferenceById(id);
        apps.setStatus(AppsStatus.REPAID);
        appsRepo.save(apps);
        return "redirect:/credits/my";
    }

    @PostMapping("/form/{id}")
    public String creditForm(@PathVariable Long id, @RequestParam int sum, @RequestParam int term) {
        appsRepo.save(new Apps(creditsRepo.getReferenceById(id), getUser(), sum, term));
        return "redirect:/credits/{id}";
    }

    @PostMapping("/search")
    public String credits(Model model, @RequestParam Goals goal) {
        AddAttributesCreditsSearch(model, goal);
        return "credits";
    }

    @GetMapping("/add")
    public String creditAdd(Model model) {
        AddAttributesCreditAdd(model);
        return "creditAdd";
    }

    @PostMapping("/add")
    public String creditAdd(Model model, @RequestParam String name, @RequestParam int rate, @RequestParam int minTerm, @RequestParam int maxTerm, @RequestParam int minLimit, @RequestParam int maxLimit, @RequestParam Goals goal, @RequestParam MultipartFile file, @RequestParam String description) {
        String res = "";
        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();
            boolean createDir = true;
            try {
                File uploadDir = new File(uploadImg);
                if (!uploadDir.exists()) createDir = uploadDir.mkdir();
                if (createDir) {
                    res = "credits/" + uuidFile + "_" + file.getOriginalFilename();
                    file.transferTo(new File(uploadImg + "/" + res));
                }
            } catch (Exception e) {
                model.addAttribute("message", "Некорректный данные!");
                AddAttributesCreditAdd(model);
                return "creditAdd";
            }
        }

        creditsRepo.save(new Credits(name, rate, minTerm, maxTerm, minLimit, maxLimit, goal, res, description));
        return "redirect:/credits/add";
    }

}
