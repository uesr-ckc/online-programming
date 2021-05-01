package com.onlineProgramming.controller;

import com.onlineProgramming.Entity.PackageEntity;
import com.onlineProgramming.Entity.User;
import com.onlineProgramming.Service.CodeCompileAndExeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author CKC
 * @DateTime 2021/4/27 11:04
 */
@RestController
public class CAEController {
    
    @Resource
    private CodeCompileAndExeService codeCompileAndExeService;
    
    @GetMapping("/run")
    public String compileAndExe(@RequestParam("filename") String filename,
                                @RequestParam("con") String con,
                                @RequestParam("suffix") String suffix,
                                HttpSession session) {
        User user = (User) session.getAttribute("user");
        
        if (filename.trim().equals("") && con.trim().equals("")) {
            return "error";
        }
        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setContents(con);
        packageEntity.setSuffix(suffix);
        packageEntity.setFilename(filename);
        packageEntity.setUser(user);
        
        if (!suffix.equals("java")) {
            return codeCompileAndExeService.ExcC(packageEntity);
        }
        return codeCompileAndExeService.ExeJava(packageEntity);
    }
    
    @GetMapping("/compile")
    public String CompileC_CPP(@RequestParam("filename") String filename,
                               @RequestParam("con") String con,
                               @RequestParam("suffix") String suffix,
                               HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (filename.trim().equals("") && con.trim().equals("")) {
            return "error";
        }
        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setContents(con);
        packageEntity.setSuffix(suffix);
        packageEntity.setFilename(filename);
        packageEntity.setUser(user);
        
        
        String exC = codeCompileAndExeService.ExC(packageEntity);
        if (exC.trim().equals("\n")) {
            return "编译成功";
        }
        return exC;
    }
}
