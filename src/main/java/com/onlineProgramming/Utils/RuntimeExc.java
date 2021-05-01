package com.onlineProgramming.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author CKC
 * @DateTime 2021/4/27 11:12
 */
public class RuntimeExc {
    private static final Runtime runtime = Runtime.getRuntime();
    private static final String dir;
    
    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            dir = "D:";
        } else {
            dir = "/root";
        }
        
        
    }
    
    /**
     * @param filename java 调用cmd编译Java文件
     * @param filepath 用户的目录名
     * @return 编译成功返回null ，编译错误返回错误结果
     */
    public static String CompileJava(String filename, String filepath) {
        StringBuilder b = new StringBuilder();
        try {
            Process process = runtime.exec("javac\t" + dir + File.separator + "problem" + File.separator + filepath + File.separator + filename + ".java");
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(sis, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                b.append(line).append("\n");
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        if (b.toString().trim().equals("")) {
            return null;
        }
        return b.toString();
    }
    
    /**
     * @param fileName 文件名
     * @param filepath 用户目录名
     * @return 返回执行结果
     * "java -cp D:\\Project Code02_Random"
     */
    public static String ExeJava(String fileName, String filepath) {
        StringBuffer b = new StringBuffer();
        try {
            Process process = runtime.exec("java -cp " + dir + File.separator + "problem" + File.separator + filepath + File.separator + "\t" + fileName);
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(sis, StandardCharsets.UTF_8));//Charset.forName("GBK")
            String line;
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return b.toString();
    }
    
    //gcc hello.c -o hello
    
    /**
     * @param filename 文件的名字
     * @param suffix   文件后缀名
     * @param dir1     用户的目录名
     * @return
     */
    public static String CompileC(String filename, String suffix, String dir1) {
        StringBuffer b = new StringBuffer();
        try {
            String path = dir + File.separator + "problem" + File.separator + dir1 + File.separator;
            Process process = runtime.exec("gcc " + path + filename + "." + suffix + "\t-o\t " + path + filename);
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(sis, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toString();
    }
    
    /**
     * @param filename 文件名字
     * @param path     用户的目录名
     * @return
     */
    public static String ExcC(String filename, String path) {
        StringBuffer b = new StringBuffer();
        try {
            String filePath = dir + File.separator + "problem" + File.separator + path + File.separator + "./";
            Process process = runtime.exec(filePath + filename);
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(sis, StandardCharsets.UTF_8));//Charset.forName("GBK")
            String line;
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toString();
    }
}
