package com.onlineProgramming.controller;


import com.onlineProgramming.Entity.ProblemUtils;
import com.onlineProgramming.Entity.User;
import com.onlineProgramming.Service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author CKC
 * @DateTime 2021/4/28 20:42
 */
@Controller
public class ProblemController {
    @Resource
    private ProblemService problemService;
    
    @RequestMapping("/problem")
    @ResponseBody
    public ProblemUtils problemUtils() {
        return problemService.Problem();
    }
    
    @GetMapping("/problemView")
    public String index(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("username", user.getUsername());
        return "problemView";
    }
    
    @GetMapping("/info")
    public String modifyInfo() {
        return "InformationView";
    }
}
