package com.onlineProgramming.controller;

import com.onlineProgramming.Entity.User;
import com.onlineProgramming.Service.UserMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author CKC
 * @DateTime 2021/4/28 18:42
 */
@Controller
public class LoginController {
    
    @Resource
    private UserMapperService userMapperService;
    
    @GetMapping("/registeredView")
    public String registeredView() {
        return "registeredView";
    }
    
    @RequestMapping(value = {"/", "/loginView"})
    public String userLogin() {
        return "userLogin";
    }
    
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        User user1 = userMapperService.inquiryUser(user);
        if (user1 == null) {
            model.addAttribute("msg", "未检测到该用户!");
            return "/userLogin";
        } else {
            session.setAttribute("user", user1);
            return "redirect:/problemView";
        }
    }
    
    /**
     * @param user 至少包含userId username password
     * @return
     */
    @RequestMapping("/registered")
    public String registered(User user, Model model) {
        
        if (user.getUserId() == null && user.getUsername() == null && user.getPassword() == null &&
                user.getPassword().trim().equals("") && user.getUserId().trim().equals("") && user.getUsername().trim().equals("")) {
            model.addAttribute("msg", "请重新检查表单数据！");
            return "registeredView";
        } else if (userMapperService.insertUser(user) < 0) {
            model.addAttribute("msg", "数据库插入失败！");
            return "registeredView";
        }
        return "redirect:loginView";
    }
}
