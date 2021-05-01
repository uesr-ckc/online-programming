package com.onlineProgramming.Service.Impl;

import com.onlineProgramming.Dao.CodeCompileAndExe;
import com.onlineProgramming.Entity.PackageEntity;
import com.onlineProgramming.Service.CodeCompileAndExeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CKC
 * @DateTime 2021/4/28 16:31
 */
@Service
public class CodeCompileAndExeServiceImpl implements CodeCompileAndExeService {
    
    @Resource
    private CodeCompileAndExe codeCompileAndExe;
    
    @Override
    public String ExeJava(PackageEntity packageEntity) {
        return codeCompileAndExe.ExeJava(packageEntity.getFilename(), packageEntity.getContents(), packageEntity.getSuffix(), packageEntity.getUser().getFilepath());
    }
    
    @Override
    public String ExcC(PackageEntity packageEntity) {
        return codeCompileAndExe.ExcC(packageEntity.getFilename(), packageEntity.getContents(), packageEntity.getSuffix(), packageEntity.getUser().getFilepath());
    }
    
    @Override
    public String ExC(PackageEntity packageEntity) {
        return codeCompileAndExe.Exc(packageEntity.getFilename(), packageEntity.getUser().getFilepath());
    }
}
