package com.onlineProgramming.controller;

import com.onlineProgramming.Entity.User;
import com.onlineProgramming.Service.UserMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author CKC
 * @DateTime 2021/4/30 14:47
 */
@Controller
public class UserController {
    @Resource
    private UserMapperService userMapperService;
    
    @PostMapping("/modify")
    public String modify(User user, HttpSession session, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user.getUserId().trim().equals("") || user.getUserId() == null) {
            user.setUserId(user1.getUserId());
        }
        if (user.getUsername().trim().equals("") || user.getUsername() == null) {
            user.setUsername(user1.getUsername());
        }
        if (user.getPassword().trim().equals("") || user.getPassword() == null) {
            user.setPassword(user1.getPassword());
        }
        if (user.getEmail().trim().equals("") || user.getEmail() == null) {
            user.setEmail(user1.getEmail());
        }
        user.setFilepath(user1.getFilepath());
        userMapperService.updateUser(user);
        session.removeAttribute("user");
        model.addAttribute("msg", "修改成功");
        
        return "redirect:/loginView";
    }
    
    public String modifyInformation() {
        return "";
    }
    
    
}
