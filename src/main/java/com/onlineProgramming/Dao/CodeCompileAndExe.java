package com.onlineProgramming.Dao;

/**
 * @author CKC
 * @DateTime 2021/4/27 21:04
 */
public interface CodeCompileAndExe {
    
    String ExeJava(String filename, String contents, String suffix, String path);
    
    String ExcC(String filename, String contents, String suffix, String path);
    
    String Exc(String filename, String path);
}
