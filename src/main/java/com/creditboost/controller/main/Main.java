package com.creditboost.controller.main;

import com.creditboost.model.Users;
import com.creditboost.repo.AppsRepo;
import com.creditboost.repo.CreditsRepo;
import com.creditboost.repo.UserDescriptionsRepo;
import com.creditboost.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Main {

    @Autowired
    protected AppsRepo appsRepo;
    @Autowired
    protected CreditsRepo creditsRepo;
    @Autowired
    protected UserDescriptionsRepo userDescriptionsRepo;
    @Autowired
    protected UsersRepo usersRepo;
    @Value("${upload.img}")
    protected String uploadImg;

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }
}