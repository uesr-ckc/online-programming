package com.onlineProgramming.Service;

import com.onlineProgramming.Entity.PackageEntity;

/**
 * @author CKC
 * @DateTime 2021/4/28 16:31
 */
public interface CodeCompileAndExeService {
    
    String ExeJava(PackageEntity packageEntity);
    
    String ExcC(PackageEntity packageEntity);
    
    String ExC(PackageEntity packageEntity);
}
