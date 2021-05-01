package com.onlineProgramming.Dao.Impl;

import com.onlineProgramming.Dao.CodeCompileAndExe;
import com.onlineProgramming.Utils.FIleUtils;
import com.onlineProgramming.Utils.RuntimeExc;
import org.springframework.stereotype.Service;

/**
 * @author CKC
 * @DateTime 2021/4/27 21:03
 */
@Service
public class CodeCompileAndExeImpl implements CodeCompileAndExe {
    @Override
    public String ExeJava(String filename, String contents, String suffix, String path) {
        boolean file = FIleUtils.createFile(filename, contents, suffix, path);
        if (!file) {
            return "本地文件创建失败！";
        }
        String compile = RuntimeExc.CompileJava(filename, path);
        if (compile != null) {
            return compile;
        }
        return RuntimeExc.ExeJava(filename, path);
    }
    
    
    /**
     * 编译 C  C++
     *
     * @param filename
     * @param contents
     * @param suffix
     * @param path
     * @return
     */
    @Override
    public String ExcC(String filename, String contents, String suffix, String path) {
        boolean file = FIleUtils.createFile(filename, contents, suffix, path);
        if (!file) {
            return "本地文件创建失败！";
        }
        String compile = RuntimeExc.CompileC(filename, suffix, path);
        return compile;
        
    }
    
    /**
     * 执行C C++
     *
     * @param filename
     * @param path
     * @return
     */
    @Override
    public String Exc(String filename, String path) {
        
        return RuntimeExc.ExcC(filename, path);
    }
    
}
